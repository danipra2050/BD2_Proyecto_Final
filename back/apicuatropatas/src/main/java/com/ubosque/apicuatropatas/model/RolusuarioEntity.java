package com.ubosque.apicuatropatas.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rolusuario", schema = "public", catalog = "PPDBYBA_DB")
public class RolusuarioEntity {
    private String codigorol;
    private String nombrerol;
    private boolean activo;

    @Id
    @Column(name = "codigorol")
    public String getCodigorol() {
        return codigorol;
    }

    public void setCodigorol(String codigorol) {
        this.codigorol = codigorol;
    }

    @Basic
    @Column(name = "nombrerol")
    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
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
        RolusuarioEntity that = (RolusuarioEntity) o;
        return activo == that.activo && Objects.equals(codigorol, that.codigorol) && Objects.equals(nombrerol, that.nombrerol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigorol, nombrerol, activo);
    }
}
