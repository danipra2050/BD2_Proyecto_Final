package com.ubosque.apicuatropatas.api;

import com.ubosque.apicuatropatas.controller.PetController;
import com.ubosque.apicuatropatas.modelapi.CaseRequest;
import com.ubosque.apicuatropatas.modelapi.PetRequest;
import com.ubosque.apicuatropatas.modelapi.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pet")
public class PetResource {

    private final PetController petController = new PetController();

    @POST
    @Path("/createpet")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPet(PetRequest pet){
        return petController.createUpdatePet(pet);
    }

    @POST
    @Path("/petlist")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response petsByOwner(PetRequest pet){
        return petController.petsByOwner(pet.getDocumentousuario());
    }

    @POST
    @Path("/petcase")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response petsCase(CaseRequest caseRequest){
        return petController.createCase(caseRequest);
    }
}
