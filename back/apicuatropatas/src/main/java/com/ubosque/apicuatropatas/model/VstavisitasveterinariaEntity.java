package com.ubosque.apicuatropatas.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "vstavisitasveterinaria", schema = "public", catalog = "PPDBYBA_DB")
public class VstavisitasveterinariaEntity {
    private String nombremascota;
    private Integer edad;
    private String tamano;
    private String peligroso;
    private Timestamp fecharegistro;
    private String observacion;
    private String documentousuario;

    @Basic
    @Column(name = "nombremascota")
    public String getNombremascota() {
        return nombremascota;
    }

    public void setNombremascota(String nombremascota) {
        this.nombremascota = nombremascota;
    }

    @Basic
    @Column(name = "edad")
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "tamano")
    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    @Basic
    @Column(name = "peligroso")
    public String getPeligroso() {
        return peligroso;
    }

    public void setPeligroso(String peligroso) {
        this.peligroso = peligroso;
    }

    @Basic
    @Column(name = "fecharegistro")
    public Timestamp getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Timestamp fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Basic
    @Column(name = "observacion")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Basic
    @Column(name = "documentousuario")
    public String getDocumentousuario() {
        return documentousuario;
    }

    public void setDocumentousuario(String documentousuario) {
        this.documentousuario = documentousuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VstavisitasveterinariaEntity that = (VstavisitasveterinariaEntity) o;
        return Objects.equals(nombremascota, that.nombremascota) && Objects.equals(edad, that.edad) && Objects.equals(tamano, that.tamano) && Objects.equals(peligroso, that.peligroso) && Objects.equals(fecharegistro, that.fecharegistro) && Objects.equals(observacion, that.observacion) && Objects.equals(documentousuario, that.documentousuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombremascota, edad, tamano, peligroso, fecharegistro, observacion, documentousuario);
    }
}
