package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "caso", schema = "public", catalog = "PPDBYBA_DB")
public class CasoEntity {
    private String codigocaso;
    private String codigotipocaso;
    private String codigomascota;
    private String observacion;
    private Timestamp fecharegistro;

    @Id
    @Column(name = "codigocaso")
    public String getCodigocaso() {
        return codigocaso;
    }

    public void setCodigocaso(String codigocaso) {
        this.codigocaso = codigocaso;
    }

    @Basic
    @Column(name = "codigotipocaso")
    public String getCodigotipocaso() {
        return codigotipocaso;
    }

    public void setCodigotipocaso(String codigotipocaso) {
        this.codigotipocaso = codigotipocaso;
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
    @Column(name = "observacion")
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Basic
    @Column(name = "fecharegistro")
    public Timestamp getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Timestamp fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CasoEntity that = (CasoEntity) o;
        return Objects.equals(codigocaso, that.codigocaso) && Objects.equals(codigotipocaso, that.codigotipocaso) && Objects.equals(codigomascota, that.codigomascota) && Objects.equals(observacion, that.observacion) && Objects.equals(fecharegistro, that.fecharegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigocaso, codigotipocaso, codigomascota, observacion, fecharegistro);
    }
}
