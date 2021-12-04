package com.ubosque.apicuatropatas.interfaces;

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
     * Método para crear la localización de una mascota Redis que explira en un tiempo determinado
     * @param chip String
     * @param location String
     * @return response Response
     */
    Response createLocation(String chip, String location);

    /**
     * Creación de JSON necesario para obetener la localizacion de la mascota
     * @param chip String
     * @return response Response
     */
    Response createPetLocation(String chip);
}
