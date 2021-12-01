package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "visita", schema = "public", catalog = "PPDBYBA_DB")
public class VisitaEntity {
    private String codigovisita;
    private String codigomascota;
    private String coditotipovisita;
    private String documentousuario;
    private Timestamp fecharegistro;
    private String observacion;

    @Id
    @Column(name = "codigovisita")
    public String getCodigovisita() {
        return codigovisita;
    }

    public void setCodigovisita(String codigovisita) {
        this.codigovisita = codigovisita;
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
    @Column(name = "coditotipovisita")
    public String getCoditotipovisita() {
        return coditotipovisita;
    }

    public void setCoditotipovisita(String coditotipovisita) {
        this.coditotipovisita = coditotipovisita;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitaEntity that = (VisitaEntity) o;
        return Objects.equals(codigovisita, that.codigovisita) && Objects.equals(codigomascota, that.codigomascota) && Objects.equals(coditotipovisita, that.coditotipovisita) && Objects.equals(documentousuario, that.documentousuario) && Objects.equals(fecharegistro, that.fecharegistro) && Objects.equals(observacion, that.observacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigovisita, codigomascota, coditotipovisita, documentousuario, fecharegistro, observacion);
    }
}
