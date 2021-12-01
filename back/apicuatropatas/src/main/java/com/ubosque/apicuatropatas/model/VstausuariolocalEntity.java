package com.ubosque.apicuatropatas.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "vstausuariolocal", schema = "public", catalog = "PPDBYBA_DB")
public class VstausuariolocalEntity {
    private String nombrelocalidad;
    private Long cantusr;
    private Long cantmasc;

    @Basic
    @Column(name = "nombrelocalidad")
    public String getNombrelocalidad() {
        return nombrelocalidad;
    }

    public void setNombrelocalidad(String nombrelocalidad) {
        this.nombrelocalidad = nombrelocalidad;
    }

    @Basic
    @Column(name = "cantusr")
    public Long getCantusr() {
        return cantusr;
    }

    public void setCantusr(Long cantusr) {
        this.cantusr = cantusr;
    }

    @Basic
    @Column(name = "cantmasc")
    public Long getCantmasc() {
        return cantmasc;
    }

    public void setCantmasc(Long cantmasc) {
        this.cantmasc = cantmasc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VstausuariolocalEntity that = (VstausuariolocalEntity) o;
        return Objects.equals(nombrelocalidad, that.nombrelocalidad) && Objects.equals(cantusr, that.cantusr) && Objects.equals(cantmasc, that.cantmasc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombrelocalidad, cantusr, cantmasc);
    }
}
