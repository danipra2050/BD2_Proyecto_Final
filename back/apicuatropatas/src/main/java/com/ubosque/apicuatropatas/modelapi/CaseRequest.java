package com.ubosque.apicuatropatas.modelapi;

public class CaseRequest {

    private String codigoCaso;
    private String tipoCaso;
    private String codigoMascota;
    private String observacion;

    public CaseRequest() {
    }

    public CaseRequest(String codigoCaso, String tipoCaso, String codigoMascota, String observacion) {
        this.codigoCaso = codigoCaso;
        this.tipoCaso = tipoCaso;
        this.codigoMascota = codigoMascota;
        this.observacion = observacion;
    }

    public String getCodigoCaso() {
        return codigoCaso;
    }

    public void setCodigoCaso(String codigoCaso) {
        this.codigoCaso = codigoCaso;
    }

    public String getTipoCaso() {
        return tipoCaso;
    }

    public void setTipoCaso(String tipoCaso) {
        this.tipoCaso = tipoCaso;
    }

    public String getCodigoMascota() {
        return codigoMascota;
    }

    public void setCodigoMascota(String codigoMascota) {
        this.codigoMascota = codigoMascota;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
