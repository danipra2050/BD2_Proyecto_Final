package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tipodocumento", schema = "public", catalog = "PPDBYBA_DB")
public class TipodocumentoEntity {
    private String codigotipodocumento;
    private String nombretipodocumento;
    private boolean activo;

    @Id
    @Column(name = "codigotipodocumento")
    public String getCodigotipodocumento() {
        return codigotipodocumento;
    }

    public void setCodigotipodocumento(String codigotipodocumento) {
        this.codigotipodocumento = codigotipodocumento;
    }

    @Basic
    @Column(name = "nombretipodocumento")
    public String getNombretipodocumento() {
        return nombretipodocumento;
    }

    public void setNombretipodocumento(String nombretipodocumento) {
        this.nombretipodocumento = nombretipodocumento;
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
        TipodocumentoEntity that = (TipodocumentoEntity) o;
        return activo == that.activo && Objects.equals(codigotipodocumento, that.codigotipodocumento) && Objects.equals(nombretipodocumento, that.nombretipodocumento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigotipodocumento, nombretipodocumento, activo);
    }
}
