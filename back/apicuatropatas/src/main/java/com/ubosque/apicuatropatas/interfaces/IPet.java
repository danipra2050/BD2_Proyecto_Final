package com.ubosque.apicuatropatas.interfaces;

import com.ubosque.apicuatropatas.modelapi.CaseRequest;
import com.ubosque.apicuatropatas.modelapi.MicrochipModel;
import com.ubosque.apicuatropatas.modelapi.PetRequest;
import com.ubosque.apicuatropatas.modelapi.Response;

public interface IPet{

    /**
     * Método para la creación de la mascota
     * @param pet PetRequest
     * @return response Response
     */
    Response createUpdatePet(PetRequest pet);

    /**
     * Método que lista las mascotas de un propietario
     * @param idOwner String
     * @return response Response
     */
    Response petsByOwner(String idOwner);

    /**
     * Método para crear información relacionada con el chip y los de salud de la mascota
     * @param microchipData MicrochipModel
     * @return response Response
     */
    Response createChip(MicrochipModel microchipData);

    /**
     * Creación de JSON necesario para obetener la localizacion de la mascota
     * @param chip String
     * @return response Response
     */
    Response createPetLocation(String chip);

    /**
     * Método con el cual se crean los casos asociados a una mascota
     * @parm caseRequest CaseRequest
     * @return response Response
     */
    Response createCase(CaseRequest caseRequest);
}
