package com.ubosque.apicuatropatas.modelapi;

public class PetRequest {

    private String codigo;
    private String documentousuario;
    private String nombremascota;
    private int edad;
    private String especie;
    private String sexo;
    private double tamano;
    private int peligroso;
    private String foto;
    private String chip;
    private int activo;

    public PetRequest() {
    }

    public PetRequest(String codigo, String documentousuario, String nombremascota, int edad, String especie,
                      String sexo, double tamano, int peligroso, String foto, String chip, int activo) {
        this.codigo = codigo;
        this.documentousuario = documentousuario;
        this.nombremascota = nombremascota;
        this.edad = edad;
        this.especie = especie;
        this.sexo = sexo;
        this.tamano = tamano;
        this.peligroso = peligroso;
        this.foto = foto;
        this.chip = chip;
        this.activo = activo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDocumentousuario() {
        return documentousuario;
    }

    public void setDocumentousuario(String documentousuario) {
        this.documentousuario = documentousuario;
    }

    public String getNombremascota() {
        return nombremascota;
    }

    public void setNombremascota(String nombremascota) {
        this.nombremascota = nombremascota;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    public int isPeligroso() {
        return peligroso;
    }

    public void setPeligroso(int peligroso) {
        this.peligroso = peligroso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getPeligroso() {
        return peligroso;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
