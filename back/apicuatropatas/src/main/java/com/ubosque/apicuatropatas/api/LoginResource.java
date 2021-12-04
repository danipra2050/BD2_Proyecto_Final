package com.ubosque.apicuatropatas.api;

import com.ubosque.apicuatropatas.controller.LoginController;
import com.ubosque.apicuatropatas.modelapi.LoginRequest;
import com.ubosque.apicuatropatas.modelapi.Response;
import com.ubosque.apicuatropatas.modelapi.UsuarioRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class LoginResource {

    private final LoginController login = new LoginController();

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest loginRequest){
        return login.login(loginRequest);
    }

    @POST
    @Path("/signup")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response signUp(UsuarioRequest usuario){
        return login.signUp(usuario);
    }

    @POST
    @Path("/signupofficial")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response signUpOfficial(UsuarioRequest usuario){
        return login.createOfficial(usuario);
    }
}
