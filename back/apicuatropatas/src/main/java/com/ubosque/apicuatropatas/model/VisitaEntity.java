package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "visita")
@Entity
public class VisitaEntity {
    @Id
    @Column(name = "codigovisita", nullable = false, length = 10)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigomascota", nullable = false)
    private MascotaEntity codigomascota;

    @ManyToOne(optional = false)
    @JoinColumn(name = "coditotipovisita", nullable = false)
    private TipovisitaEntity coditotipovisita;

    @ManyToOne(optional = false)
    @JoinColumn(name = "documentousuario", nullable = false)
    private UsuarioEntity documentousuario;

    @Column(name = "fecharegistro", nullable = false)
    private Instant fecharegistro;

    @Column(name = "observacion", nullable = false, length = 500)
    private String observacion;

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Instant getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public UsuarioEntity getDocumentousuario() {
        return documentousuario;
    }

    public void setDocumentousuario(UsuarioEntity documentousuario) {
        this.documentousuario = documentousuario;
    }

    public TipovisitaEntity getCoditotipovisita() {
        return coditotipovisita;
    }

    public void setCoditotipovisita(TipovisitaEntity coditotipovisita) {
        this.coditotipovisita = coditotipovisita;
    }

    public MascotaEntity getCodigomascota() {
        return codigomascota;
    }

    public void setCodigomascota(MascotaEntity codigomascota) {
        this.codigomascota = codigomascota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}