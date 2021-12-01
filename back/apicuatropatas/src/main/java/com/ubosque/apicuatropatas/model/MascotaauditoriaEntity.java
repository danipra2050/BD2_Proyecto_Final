package com.ubosque.apicuatropatas.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "mascotaauditoria", schema = "public", catalog = "PPDBYBA_DB")
public class MascotaauditoriaEntity {
    private int codigoauditoria;
    private String codigomascota;
    private String documentousuario;
    private String nombreusuario;
    private String nombremascota;
    private int edad;
    private String especie;
    private String sexo;
    private BigInteger tamano;
    private boolean peligroso;
    private String foto;
    private boolean activo;
    private String accionauditoria;
    private Timestamp fechaauditoria;

    @Basic
    @Column(name = "codigoauditoria")
    public int getCodigoauditoria() {
        return codigoauditoria;
    }

    public void setCodigoauditoria(int codigoauditoria) {
        this.codigoauditoria = codigoauditoria;
    }

    @Basic
    @Column(name = "codigomascota")
    public String getCodigomascota() {
        return codigomascota;
    }

    public void setCodigomascota(String codigomascota) {
        this.codigomascota = codigomascota;
    }

    @Basic
    @Column(name = "documentousuario")
    public String getDocumentousuario() {
        return documentousuario;
    }

    public void setDocumentousuario(String documentousuario) {
        this.documentousuario = documentousuario;
    }

    @Basic
    @Column(name = "nombreusuario")
    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

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
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "especie")
    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Basic
    @Column(name = "sexo")
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "tamano")
    public BigInteger getTamano() {
        return tamano;
    }

    public void setTamano(BigInteger tamano) {
        this.tamano = tamano;
    }

    @Basic
    @Column(name = "peligroso")
    public boolean isPeligroso() {
        return peligroso;
    }

    public void setPeligroso(boolean peligroso) {
        this.peligroso = peligroso;
    }

    @Basic
    @Column(name = "foto")
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Basic
    @Column(name = "activo")
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Basic
    @Column(name = "accionauditoria")
    public String getAccionauditoria() {
        return accionauditoria;
    }

    public void setAccionauditoria(String accionauditoria) {
        this.accionauditoria = accionauditoria;
    }

    @Basic
    @Column(name = "fechaauditoria")
    public Timestamp getFechaauditoria() {
        return fechaauditoria;
    }

    public void setFechaauditoria(Timestamp fechaauditoria) {
        this.fechaauditoria = fechaauditoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MascotaauditoriaEntity that = (MascotaauditoriaEntity) o;
        return codigoauditoria == that.codigoauditoria && edad == that.edad && peligroso == that.peligroso && activo == that.activo && Objects.equals(codigomascota, that.codigomascota) && Objects.equals(documentousuario, that.documentousuario) && Objects.equals(nombreusuario, that.nombreusuario) && Objects.equals(nombremascota, that.nombremascota) && Objects.equals(especie, that.especie) && Objects.equals(sexo, that.sexo) && Objects.equals(tamano, that.tamano) && Objects.equals(foto, that.foto) && Objects.equals(accionauditoria, that.accionauditoria) && Objects.equals(fechaauditoria, that.fechaauditoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoauditoria, codigomascota, documentousuario, nombreusuario, nombremascota, edad, especie, sexo, tamano, peligroso, foto, activo, accionauditoria, fechaauditoria);
    }
}
