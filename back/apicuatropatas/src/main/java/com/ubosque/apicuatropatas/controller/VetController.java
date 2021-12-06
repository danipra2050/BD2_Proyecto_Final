package com.ubosque.apicuatropatas.controller;

import com.ubosque.apicuatropatas.constant.Constante;
import com.ubosque.apicuatropatas.interfaces.IVet;
import com.ubosque.apicuatropatas.model.*;
import com.ubosque.apicuatropatas.modelapi.PetRequest;
import com.ubosque.apicuatropatas.modelapi.Response;
import com.ubosque.apicuatropatas.modelapi.VisitaRequest;
import com.ubosque.apicuatropatas.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;

public class VetController implements IVet {

    private Response response;

    @Override
    public Response createVisit(VisitaRequest visita) {
        response = new Response();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            VisitaEntity visitaEntity = new VisitaEntity();

            visitaEntity.setId(visitaId());
            visitaEntity.setObservacion(visita.getObservacion());
            visitaEntity.setFecharegistro(new Date().toInstant());

            UsuarioEntity usuario = new UsuarioEntity();
            usuario.setId(visita.getUsuario());
            visitaEntity.setDocumentousuario(usuario);

            MascotaEntity mascota = new MascotaEntity();
            mascota.setId(visita.getCodigoMascota());
            visitaEntity.setCodigomascota(mascota);

            TipovisitaEntity tipoVisita = new TipovisitaEntity();
            tipoVisita.setCodigotipovisita(visita.getTipoVisita());
            visitaEntity.setCoditotipovisita(tipoVisita);

            if(visita.getTipoVisita().contains(Constante.Id.VISITA_CHIP)){
                PetRequest p = new PetRequest();
                p.setCodigo(visita.getCodigoMascota());
                p.setChip(visita.getChip());
                assignChip(p);
            }



            session.save(visitaEntity);
            session.getTransaction().commit();
            session.close();

            response.setCode(Constante.ResponseCode.SUCCESS);
            response.setMessage(Constante.ResponseMesg.SUCCESS);
            response.setData(visitaEntity);
        }catch(Exception ex){
            response.setCode(Constante.ResponseCode.ERROR);
            response.setMessage(ex.getMessage());
            if(session != null)
                session.getTransaction().rollback();
        }
        return response;
    }

    @Override
    public Response assignChip(PetRequest petRequest) {
        response = new Response();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query<MascotaEntity> q = session.createQuery("FROM MascotaEntity WHERE id = :codPet", MascotaEntity.class)
                    .setParameter("codPet", petRequest.getCodigo());
            MascotaEntity petEntity = q.uniqueResult();
            petEntity.setChip(petRequest.getChip());

            if(petEntity.getChip().isEmpty()) {
                session.update(petEntity);
                session.getTransaction().commit();
                session.close();

                response.setCode(Constante.ResponseCode.SUCCESS);
                response.setMessage(Constante.ResponseMesg.SUCCESS);
                response.setData(petEntity);
            }else{
                response.setCode("401");
                response.setMessage("Mascota con chip asociado.");
            }


        }catch(Exception ex){
            response.setCode(Constante.ResponseCode.ERROR);
            response.setMessage(ex.getMessage());
            if(session != null)
                session.getTransaction().rollback();
        }
        return null;
    }

    private String visitaId(){
        String lastId = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<VisitaEntity> query = session.createQuery("from VisitaEntity ORDER BY id desc ", VisitaEntity.class)
                .setMaxResults(1);
        VisitaEntity visita = query.uniqueResult();
        if (visita == null) {
            lastId = Constante.Id.VISIT_ID.concat("001");
        } else {
            int lId = Integer.parseInt(visita.getId().substring(4)) + 1;
            lastId = Constante.Id.VISIT_ID + (lId < 10 ? "00".concat(String.valueOf(lId)) : "0".concat(String.valueOf(lId)));
        }
        return lastId;
    }
}
