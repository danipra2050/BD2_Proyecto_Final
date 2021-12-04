package com.ubosque.apicuatropatas.model;

import javax.persistence.*;

@Table(name = "mascota", indexes = {
        @Index(name = "idx_mascota_nommascota", columnList = "nombremascota"),
        @Index(name = "idx_mascota_edad", columnList = "edad")
})
@Entity
public class MascotaEntity {
    @Id
    @Column(name = "codigomascota", nullable = false, length = 10)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "documentousuario", nullable = false)
    private UsuarioEntity documentousuario;

    @Column(name = "nombremascota", nullable = false, length = 30)
    private String nombremascota;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "especie", nullable = false, length = 30)
    private String especie;

    @Column(name = "sexo", nullable = false, length = 2)
    private String sexo;

    @Column(name = "tamano", nullable = false)
    private Double tamano;

    @Column(name = "peligroso", nullable = false)
    private Integer peligroso;

    @Column(name = "foto", nullable = false, length = 50)
    private String foto;

    @Column(name = "activo", nullable = false)
    private Integer activo;

    @Column(name = "chip", length = 50)
    private String chip;

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getPeligroso() {
        return peligroso;
    }

    public void setPeligroso(Integer peligroso) {
        this.peligroso = peligroso;
    }

    public Double getTamano() {
        return tamano;
    }

    public void setTamano(Double tamano) {
        this.tamano = tamano;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombremascota() {
        return nombremascota;
    }

    public void setNombremascota(String nombremascota) {
        this.nombremascota = nombremascota;
    }

    public UsuarioEntity getDocumentousuario() {
        return documentousuario;
    }

    public void setDocumentousuario(UsuarioEntity documentousuario) {
        this.documentousuario = documentousuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}