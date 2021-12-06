package com.ubosque.apicuatropatas.controller;

import com.ubosque.apicuatropatas.constant.Constante;
import com.ubosque.apicuatropatas.interfaces.IPet;
import com.ubosque.apicuatropatas.model.CasoEntity;
import com.ubosque.apicuatropatas.model.MascotaEntity;
import com.ubosque.apicuatropatas.model.TipocasoEntity;
import com.ubosque.apicuatropatas.model.UsuarioEntity;
import com.ubosque.apicuatropatas.modelapi.CaseRequest;
import com.ubosque.apicuatropatas.modelapi.MicrochipModel;
import com.ubosque.apicuatropatas.modelapi.PetRequest;
import com.ubosque.apicuatropatas.modelapi.Response;
import com.ubosque.apicuatropatas.util.HibernateUtil;
import com.ubosque.apicuatropatas.util.MongoUtil;
import com.ubosque.apicuatropatas.util.RedisUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.bson.Document;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.util.logging.Logger;

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
        response = new Response();
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            mongoConn.getMongoCollection().insertOne(new Document()
                     .append("petCode", microchipData.getPetCode())
                    .append("timestamp", new Timestamp(new Date().getTime()))
                    .append("microchip", microchipData.getMicrochip())
                    .append("pateName", microchipData.getPateName())
                    .append("ownerName", microchipData.getOwnerName())
                    .append("species", microchipData.getSpecies())
                    .append("geolocation", new Document()
                            .append("latitude", microchipData.getGeolocation().getLatitude())
                            .append("longitude", microchipData.getGeolocation().getLongitude()))
                    .append("vitalSigns", new Document()
                            .append("temperature", microchipData.getVitalSigns().getTemperature())
                            .append("heartRate", microchipData.getVitalSigns().getHeartRate())
                            .append("breathingFrequency", microchipData.getVitalSigns().getBreathingFrequency())
                    )
            );

            String location = microchipData.getGeolocation().getLatitude() + "_" + microchipData.getGeolocation().getLongitude();
            createLocation(microchipData.getMicrochip(), location);

            MascotaEntity petEntity = session.createQuery("FROM MascotaEntity WHERE id = :petCode", MascotaEntity.class)
                    .setParameter("petCode", microchipData.getPetCode())
                    .uniqueResult();
            petEntity.setChip(microchipData.getMicrochip());
            session.update(petEntity);
            session.getTransaction().commit();

            response.setCode(Constante.ResponseCode.SUCCESS);
            response.setMessage(Constante.ResponseMesg.SUCCESS);
        }catch (Exception ex){
            response.setCode(Constante.ResponseCode.ERROR);
            response.setMessage(ex.getMessage());
            if(session != null)
                session.getTransaction().rollback();
        }

        return response;
    }

    /**
     * Método para crear la localización de una mascota Redis que explira en un tiempo determinado
     * @param chip String
     * @param location String
     */
    private void createLocation(String chip, String location) {
        try{
            redisConn.getJedis().lpush(chip, location);
            redisConn.getJedis().expire(chip, Constante.RedisInfo.DB_EXPIRE_TIME);
        }catch (Exception ex){
            Logger.getLogger("createLocation: " + ex.getMessage());
        }
    }

    @Override
    public Response createPetLocation(String chip) {
        return null;
    }

    @Override
    public Response createCase(CaseRequest caseRequest) {
        response = new Response();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            CasoEntity caso = new CasoEntity();
            caso.setId(caseId());

            MascotaEntity mascotaEntity = new MascotaEntity();
            mascotaEntity.setId(caseRequest.getCodigoMascota());
            caso.setCodigomascota(mascotaEntity);

            TipocasoEntity tipocasoEntity = new TipocasoEntity();
            tipocasoEntity.setCodigotipocaso(caseRequest.getTipoCaso());
            caso.setCodigotipocaso(tipocasoEntity);

            caso.setObservacion(caseRequest.getObservacion());
            caso.setFecharegistro(new Date().toInstant());
            session.save(caso);

            session.getTransaction().commit();
            response.setCode(Constante.ResponseCode.SUCCESS);
            response.setMessage(Constante.ResponseMesg.SUCCESS);
            response.setData(caso);
        }catch(Exception ex){
            response.setCode(Constante.ResponseCode.ERROR);
            response.setMessage(ex.getMessage());
            if(session != null)
                session.getTransaction().rollback();
        }
        return response;
    }

    private String getLastId(){
        String lastId = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<MascotaEntity> petQuery = session.createQuery("FROM MascotaEntity ORDER BY id DESC", MascotaEntity.class).setMaxResults(1);
            MascotaEntity pet = petQuery.getSingleResult();
            if (pet == null) {
                lastId = Constante.Id.PET_ID.concat("001");
            } else {
                int lId = Integer.parseInt(pet.getId().substring(4)) + 1;
                lastId = Constante.Id.PET_ID + (lId < 10 ? "00".concat(String.valueOf(lId)) : "0".concat(String.valueOf(lId)));
            }
        }
        return lastId;
    }

    private String caseId(){
        String lastId = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<CasoEntity> query = session.createQuery("from CasoEntity ORDER BY id desc ", CasoEntity.class)
                .setMaxResults(1);
        CasoEntity caso = query.uniqueResult();
        if (caso == null) {
            lastId = Constante.Id.CASE_ID.concat("001");
        } else {
            int lId = Integer.parseInt(caso.getId().substring(4)) + 1;
            lastId = Constante.Id.CASE_ID + (lId < 10 ? "00".concat(String.valueOf(lId)) : "0".concat(String.valueOf(lId)));
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
