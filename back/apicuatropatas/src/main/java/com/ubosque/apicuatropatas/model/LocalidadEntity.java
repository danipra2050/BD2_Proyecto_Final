package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "localidad", schema = "public", catalog = "PPDBYBA_DB")
public class LocalidadEntity {
    private String codigolocalidad;
    private String nombrelocalidad;
    private boolean activo;

    @Id
    @Column(name = "codigolocalidad")
    public String getCodigolocalidad() {
        return codigolocalidad;
    }

    public void setCodigolocalidad(String codigolocalidad) {
        this.codigolocalidad = codigolocalidad;
    }

    @Basic
    @Column(name = "nombrelocalidad")
    public String getNombrelocalidad() {
        return nombrelocalidad;
    }

    public void setNombrelocalidad(String nombrelocalidad) {
        this.nombrelocalidad = nombrelocalidad;
    }

    @Basic
    @Column(name = "activo")
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalidadEntity that = (LocalidadEntity) o;
        return activo == that.activo && Objects.equals(codigolocalidad, that.codigolocalidad) && Objects.equals(nombrelocalidad, that.nombrelocalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigolocalidad, nombrelocalidad, activo);
    }
}
