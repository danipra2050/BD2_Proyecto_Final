package com.ubosque.apicuatropatas.modelapi;

public class VisitaRequest {

    private String codigo;
    private String codigoMascota;
    private String tipoVisita;
    private String usuario;
    private String observacion;
    private String chip;

    public VisitaRequest() {
    }

    public VisitaRequest(String codigo, String codigoMascota, String tipoVisita, String usuario, String observacion) {
        this.codigo = codigo;
        this.codigoMascota = codigoMascota;
        this.tipoVisita = tipoVisita;
        this.usuario = usuario;
        this.observacion = observacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoMascota() {
        return codigoMascota;
    }

    public void setCodigoMascota(String codigoMascota) {
        this.codigoMascota = codigoMascota;
    }

    public String getTipoVisita() {
        return tipoVisita;
    }

    public void setTipoVisita(String tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }
}
