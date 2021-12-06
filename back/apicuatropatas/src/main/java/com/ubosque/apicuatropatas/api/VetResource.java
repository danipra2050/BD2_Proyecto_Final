package com.ubosque.apicuatropatas.api;

import com.ubosque.apicuatropatas.controller.VetController;
import com.ubosque.apicuatropatas.modelapi.PetRequest;
import com.ubosque.apicuatropatas.modelapi.Response;
import com.ubosque.apicuatropatas.modelapi.VisitaRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/vet")
public class VetResource {

    private VetController vetController = new VetController();

    @POST
    @Path("/createvisit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createVisit(VisitaRequest visita){
        return vetController.createVisit(visita);
    }
}
