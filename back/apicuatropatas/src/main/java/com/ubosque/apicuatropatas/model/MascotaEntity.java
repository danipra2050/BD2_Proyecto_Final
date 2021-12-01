package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "mascota", schema = "public", catalog = "PPDBYBA_DB")
public class MascotaEntity {
    private String codigomascota;
    private String documentousuario;
    private String nombremascota;
    private int edad;
    private String especie;
    private String sexo;
    private BigInteger tamano;
    private boolean peligroso;
    private String foto;
    private boolean activo;
    private String chip;

    @Id
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
    @Column(name = "chip")
    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MascotaEntity that = (MascotaEntity) o;
        return edad == that.edad && peligroso == that.peligroso && activo == that.activo && Objects.equals(codigomascota, that.codigomascota) && Objects.equals(documentousuario, that.documentousuario) && Objects.equals(nombremascota, that.nombremascota) && Objects.equals(especie, that.especie) && Objects.equals(sexo, that.sexo) && Objects.equals(tamano, that.tamano) && Objects.equals(foto, that.foto) && Objects.equals(chip, that.chip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigomascota, documentousuario, nombremascota, edad, especie, sexo, tamano, peligroso, foto, activo, chip);
    }
}
