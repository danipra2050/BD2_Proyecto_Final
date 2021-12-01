package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "barrio", schema = "public", catalog = "PPDBYBA_DB")
public class BarrioEntity {
    private String codigobarrio;
    private String nombrebarrio;
    private boolean activo;
    private String codigolocalidad;

    @Id
    @Column(name = "codigobarrio")
    public String getCodigobarrio() {
        return codigobarrio;
    }

    public void setCodigobarrio(String codigobarrio) {
        this.codigobarrio = codigobarrio;
    }

    @Basic
    @Column(name = "nombrebarrio")
    public String getNombrebarrio() {
        return nombrebarrio;
    }

    public void setNombrebarrio(String nombrebarrio) {
        this.nombrebarrio = nombrebarrio;
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
    @Column(name = "codigolocalidad")
    public String getCodigolocalidad() {
        return codigolocalidad;
    }

    public void setCodigolocalidad(String codigolocalidad) {
        this.codigolocalidad = codigolocalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BarrioEntity that = (BarrioEntity) o;
        return activo == that.activo && Objects.equals(codigobarrio, that.codigobarrio) && Objects.equals(nombrebarrio, that.nombrebarrio) && Objects.equals(codigolocalidad, that.codigolocalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigobarrio, nombrebarrio, activo, codigolocalidad);
    }
}
