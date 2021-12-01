package com.ubosque.apicuatropatas.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "microchipgoals", schema = "public", catalog = "PPDBYBA_DB")
public class MicrochipgoalsEntity {
    private Date fechainicial;
    private Date fechafinal;
    private int cantidad;
    private String cumplimiento;

    @Basic
    @Column(name = "fechainicial")
    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    @Basic
    @Column(name = "fechafinal")
    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    @Basic
    @Column(name = "cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "cumplimiento")
    public String getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(String cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MicrochipgoalsEntity that = (MicrochipgoalsEntity) o;
        return cantidad == that.cantidad && Objects.equals(fechainicial, that.fechainicial) && Objects.equals(fechafinal, that.fechafinal) && Objects.equals(cumplimiento, that.cumplimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechainicial, fechafinal, cantidad, cumplimiento);
    }
}
