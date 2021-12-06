package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "caso", catalog = "PPDBYBA_DB")
@Entity
public class CasoEntity {
    @Id
    @Column(name = "codigocaso", nullable = false, length = 10)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigotipocaso", nullable = false)
    private TipocasoEntity codigotipocaso;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigomascota", nullable = false)
    private MascotaEntity codigomascota;

    @Column(name = "observacion", nullable = false, length = 500)
    private String observacion;

    @Column(name = "fecharegistro", nullable = false)
    private Instant fecharegistro;

    public Instant getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Instant fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public MascotaEntity getCodigomascota() {
        return codigomascota;
    }

    public void setCodigomascota(MascotaEntity codigomascota) {
        this.codigomascota = codigomascota;
    }

    public TipocasoEntity getCodigotipocaso() {
        return codigotipocaso;
    }

    public void setCodigotipocaso(TipocasoEntity codigotipocaso) {
        this.codigotipocaso = codigotipocaso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}