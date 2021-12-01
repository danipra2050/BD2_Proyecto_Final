package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tipocaso", schema = "public", catalog = "PPDBYBA_DB")
public class TipocasoEntity {
    private String codigotipocaso;
    private String nombretipocaso;
    private boolean activo;

    @Id
    @Column(name = "codigotipocaso")
    public String getCodigotipocaso() {
        return codigotipocaso;
    }

    public void setCodigotipocaso(String codigotipocaso) {
        this.codigotipocaso = codigotipocaso;
    }

    @Basic
    @Column(name = "nombretipocaso")
    public String getNombretipocaso() {
        return nombretipocaso;
    }

    public void setNombretipocaso(String nombretipocaso) {
        this.nombretipocaso = nombretipocaso;
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
        TipocasoEntity that = (TipocasoEntity) o;
        return activo == that.activo && Objects.equals(codigotipocaso, that.codigotipocaso) && Objects.equals(nombretipocaso, that.nombretipocaso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigotipocaso, nombretipocaso, activo);
    }
}
