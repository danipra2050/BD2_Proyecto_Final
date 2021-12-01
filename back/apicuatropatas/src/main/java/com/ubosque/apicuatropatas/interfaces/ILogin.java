package com.ubosque.apicuatropatas.interfaces;

import com.ubosque.apicuatropatas.modelapi.LoginRequest;
import com.ubosque.apicuatropatas.modelapi.Response;
import com.ubosque.apicuatropatas.modelapi.UsuarioRequest;

public interface ILogin {

    /**
     * Método que realiza la busqueda del usuario para la autenticación
     * @param loginRequest LoginRequest
     * @return Response
     */
    Response login(LoginRequest loginRequest);

    /**
     * Método para realizar el registro del usuario
     * @param usuario UsuarioRequest
     * @return Response
     */
    Response signUp(UsuarioRequest usuario);

    /**
     * Método que permite crear un usuario de tipo funcioinario
     * @param usuario UsuarioRequest
     * @Return Response
     */
    Response createOfficial(UsuarioRequest usuario);
}
