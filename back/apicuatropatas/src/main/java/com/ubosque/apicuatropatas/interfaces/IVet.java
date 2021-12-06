package com.ubosque.apicuatropatas.interfaces;

import com.ubosque.apicuatropatas.modelapi.PetRequest;
import com.ubosque.apicuatropatas.modelapi.Response;
import com.ubosque.apicuatropatas.modelapi.VisitaRequest;

public interface IVet{

    Response createVisit(VisitaRequest visita);

    Response assignChip(PetRequest petRequest);
}
