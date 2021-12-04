package com.ubosque.apicuatropatas.controller;

import com.mongodb.Mongo;
import com.ubosque.apicuatropatas.constant.Constante;
import com.ubosque.apicuatropatas.interfaces.IPet;
import com.ubosque.apicuatropatas.model.MascotaEntity;
import com.ubosque.apicuatropatas.model.UsuarioEntity;
import com.ubosque.apicuatropatas.modelapi.MicrochipModel;
import com.ubosque.apicuatropatas.modelapi.PetRequest;
import com.ubosque.apicuatropatas.modelapi.Response;
import com.ubosque.apicuatropatas.util.HibernateUtil;
import com.ubosque.apicuatropatas.util.MongoUtil;
import com.ubosque.apicuatropatas.util.RedisUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PetController implements IPet {

    private Response response;
    private final MongoUtil mongoConn = new MongoUtil();
    private final RedisUtil redisConn = new RedisUtil();

    @Override
    public Response createUpdatePet(PetRequest pet){
        response = new Response();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            MascotaEntity petEntity = getPetEntity(pet);
            session.saveOrUpdate(petEntity);

            session.getTransaction().commit();

            response.setCode(Constante.ResponseCode.SUCCESS);
            response.setMessage(Constante.ResponseMesg.SUCCESS);
            response.setData(petEntity);
        }catch(Exception ex){
            response.setCode(Constante.ResponseCode.ERROR);
            response.setMessage(ex.getMessage());
            if(session != null)
                session.getTransaction().rollback();
        }
        return response;
    }

    @Override
    public Response petsByOwner(String idOwner) {
        response = new Response();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<MascotaEntity> petQuery = session.createQuery("FROM MascotaEntity WHERE documentousuario.id = :owner", MascotaEntity.class)
                    .setParameter("owner", idOwner);
            List<MascotaEntity> petList = petQuery.getResultList();

            response.setCode(Constante.ResponseCode.SUCCESS);
            response.setMessage(Constante.ResponseMesg.SUCCESS);
            response.setData(petList);
        }catch(Exception ex){
            response.setCode(Constante.ResponseCode.ERROR);
            response.setMessage(ex.getMessage());
        }
        return response;
    }

    @Override
    public Response createChip(MicrochipModel microchipData) {
        return null;
    }

    @Override
    public Response createLocation(String chip, String location) {
        return null;
    }

    @Override
    public Response createPetLocation(String chip) {
        return null;
    }

    private String getLastId(){
        String lastId = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<MascotaEntity> petQuery = session.createQuery("FROM MascotaEntity ORDER BY id DESC", MascotaEntity.class).setMaxResults(1);
            MascotaEntity pet = petQuery.getSingleResult();
            if(pet == null){
                lastId = Constante.Id.PET_ID.concat("001");
            }else{
                int lId = Integer.parseInt(pet.getId().substring(4)) + 1;
                lastId = Constante.Id.PET_ID + (lId < 10 ? "00".concat(String.valueOf(lId)) : "0".concat(String.valueOf(lId)));
             }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lastId;
    }

    private MascotaEntity getPetEntity(PetRequest pet){
        MascotaEntity mascotaEntity = new MascotaEntity();

        String id = pet.getCodigo() == null ? getLastId() : pet.getCodigo();
        mascotaEntity.setId(id);
        mascotaEntity.setNombremascota(pet.getNombremascota());

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(pet.getDocumentousuario());
        mascotaEntity.setDocumentousuario(usuario);

        mascotaEntity.setEdad(pet.getEdad());
        mascotaEntity.setEspecie(pet.getEspecie());
        mascotaEntity.setSexo(pet.getSexo());
        mascotaEntity.setTamano(pet.getTamano());
        mascotaEntity.setPeligroso(pet.isPeligroso());
        mascotaEntity.setFoto(pet.getFoto());
        mascotaEntity.setActivo(pet.getActivo());

        return mascotaEntity;
    }


}
