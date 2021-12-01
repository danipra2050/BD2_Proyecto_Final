package com.ubosque.apicuatropatas.modelapi;

public class UsuarioRequest {

    private String documento;
    private String codBarrio;
    private String codTipoDoc;
    private String codRol;
    private String nombre;
    private String razonSocial;
    private Long telefono;
    private String email;
    private String direccion;
    private String contrasena;

    public UsuarioRequest() {
    }

    public UsuarioRequest(String documento, String codBarrio, String codTipoDoc, String codRol, String nombre, String razonSocial, Long telefono, String email, String direccion, String contrasena) {
        this.documento = documento;
        this.codBarrio = codBarrio;
        this.codTipoDoc = codTipoDoc;
        this.codRol = codRol;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.contrasena = contrasena;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCodBarrio() {
        return codBarrio;
    }

    public void setCodBarrio(String codBarrio) {
        this.codBarrio = codBarrio;
    }

    public String getCodTipoDoc() {
        return codTipoDoc;
    }

    public void setCodTipoDoc(String codTipoDoc) {
        this.codTipoDoc = codTipoDoc;
    }

    public String getCodRol() {
        return codRol;
    }

    public void setCodRol(String codRol) {
        this.codRol = codRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
