package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "adjuntovisita", schema = "public", catalog = "PPDBYBA_DB")
public class AdjuntovisitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String codigovisita;
    private String nombreadjunto;
    private boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "codigovisita")
    public String getCodigovisita() {
        return codigovisita;
    }

    public void setCodigovisita(String codigovisita) {
        this.codigovisita = codigovisita;
    }

    @Basic
    @Column(name = "nombreadjunto")
    public String getNombreadjunto() {
        return nombreadjunto;
    }

    public void setNombreadjunto(String nombreadjunto) {
        this.nombreadjunto = nombreadjunto;
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
        AdjuntovisitaEntity that = (AdjuntovisitaEntity) o;
        return activo == that.activo && Objects.equals(codigovisita, that.codigovisita) && Objects.equals(nombreadjunto, that.nombreadjunto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigovisita, nombreadjunto, activo);
    }
}
