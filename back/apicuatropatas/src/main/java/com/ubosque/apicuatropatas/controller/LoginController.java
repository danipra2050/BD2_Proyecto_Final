package com.ubosque.apicuatropatas.controller;

import com.ubosque.apicuatropatas.constant.Constante;
import com.ubosque.apicuatropatas.interfaces.ILogin;
import com.ubosque.apicuatropatas.model.BarrioEntity;
import com.ubosque.apicuatropatas.model.RolusuarioEntity;
import com.ubosque.apicuatropatas.model.TipodocumentoEntity;
import com.ubosque.apicuatropatas.model.UsuarioEntity;
import com.ubosque.apicuatropatas.modelapi.LoginRequest;
import com.ubosque.apicuatropatas.modelapi.Response;
import com.ubosque.apicuatropatas.modelapi.UsuarioRequest;
import com.ubosque.apicuatropatas.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Clase controladora de las acciones para el manejo de los usuarios
 * @author Daniela Prado Chaparro
 * @author dpradoc@unbosque.edu.co
 */
public class LoginController implements ILogin {

    private Response response;

    @Override
    public Response login(LoginRequest loginRequest){
        response = new Response();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query<UsuarioEntity> usuarioQuery = session.createQuery("FROM UsuarioEntity WHERE email = :email AND contrasena = :password AND activo = 1", UsuarioEntity.class)
                    .setParameter("email", loginRequest.getUser())
                    .setParameter("password", loginRequest.getPassword());

            UsuarioEntity usuario = usuarioQuery.uniqueResult();
            //Validación del rol Veterinario para saber si esta o no aprobado por un funcionario y
            //permitir el acceso al aplicativo
            if(usuario.getCodigorol().getCodigorol().contains("ROL002") && (usuario.getAprobadofunc() != 1 || usuario.getAprobadofunc() == null))
                usuario = null;

            if(usuario != null){
                response.setCode(Constante.ResponseCode.SUCCESS);
                response.setMessage(Constante.ResponseMesg.SUCCESS);
                response.setData(usuario);
            }else{
                response.setCode(Constante.ResponseCode.NOT_FOUND);
                response.setMessage(Constante.ResponseMesg.NOT_FOUND);
            }
        }catch(Exception ex){
            response.setCode(Constante.ResponseCode.ERROR);
            response.setMessage(Constante.ResponseMesg.ERROR);
            response.setData(ex);
        }
        return response;
    }

    @Override
    public Response signUp(UsuarioRequest usuario) {
        response = new Response();
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(getUsuarioEntity(usuario, false));
            session.getTransaction().commit();

            response.setCode(Constante.ResponseCode.SUCCESS);
            response.setMessage(Constante.ResponseMesg.SUCCESS);
            response.setData(usuario);
        }catch(Exception ex){
            response.setCode(Constante.ResponseCode.ERROR);
            response.setMessage(ex.getMessage());
            if(session != null)
                session.getTransaction().rollback();
        }
        return response;
    }

    @Override
    public Response createOfficial(UsuarioRequest usuario) {
        response = new Response();
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(getUsuarioEntity(usuario, true));
            session.getTransaction().commit();

            response.setCode(Constante.ResponseCode.SUCCESS);
            response.setMessage(Constante.ResponseMesg.SUCCESS);
            response.setData(usuario);
        }catch(Exception ex){
            response.setCode(Constante.ResponseCode.ERROR);
            response.setMessage(ex.getMessage());
            if(session != null)
                session.getTransaction().rollback();
        }
        return response;
    }

    /**
     * Método encargado de convertir el objeto request en un objeto tipo entity para su persistencia
     * @param usuario UsuarioRequest
     * @param isFunc boolean
     * @return UsuarioEntity
     */
    private UsuarioEntity getUsuarioEntity(UsuarioRequest usuario, boolean isFunc){
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(usuario.getDocumento());

        BarrioEntity barrio = new BarrioEntity();
        barrio.setCodigobarrio(usuario.getCodBarrio());
        usuarioEntity.setCodigobarrio(barrio);

        RolusuarioEntity rol = new RolusuarioEntity();
        rol.setCodigorol(isFunc ? "ROL003" : usuario.getCodRol());
        usuarioEntity.setCodigorol(rol);

        TipodocumentoEntity tipoDoc = new TipodocumentoEntity();
        tipoDoc.setCodigotipodocumento(usuario.getCodTipoDoc());
        usuarioEntity.setCodigotipodocumento(tipoDoc);

        usuarioEntity.setNombreusuario(usuario.getNombre());
        usuarioEntity.setRazonsolcial(usuario.getRazonSocial());
        usuarioEntity.setTelefono(usuario.getTelefono());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setDireccion(usuario.getDireccion());
        usuarioEntity.setContrasena(usuario.getContrasena());
        usuarioEntity.setActivo(1);

        return usuarioEntity;
    }
}
