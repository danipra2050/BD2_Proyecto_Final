package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tipovisita", schema = "public", catalog = "PPDBYBA_DB")
public class TipovisitaEntity {
    private String codigotipovisita;
    private String nombretipovisita;
    private boolean activo;

    @Id
    @Column(name = "codigotipovisita")
    public String getCodigotipovisita() {
        return codigotipovisita;
    }

    public void setCodigotipovisita(String codigotipovisita) {
        this.codigotipovisita = codigotipovisita;
    }

    @Basic
    @Column(name = "nombretipovisita")
    public String getNombretipovisita() {
        return nombretipovisita;
    }

    public void setNombretipovisita(String nombretipovisita) {
        this.nombretipovisita = nombretipovisita;
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
        TipovisitaEntity that = (TipovisitaEntity) o;
        return activo == that.activo && Objects.equals(codigotipovisita, that.codigotipovisita) && Objects.equals(nombretipovisita, that.nombretipovisita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigotipovisita, nombretipovisita, activo);
    }
}
