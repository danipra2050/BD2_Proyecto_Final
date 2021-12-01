package com.ubosque.apicuatropatas.model;

import javax.persistence.*;

@Table(name = "usuario")
@Entity
public class UsuarioEntity {
    @Id
    @Column(name = "documentousuario", nullable = false, length = 15)
    private String id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigobarrio", nullable = false)
    private BarrioEntity codigobarrio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigotipodocumento", nullable = false)
    private TipodocumentoEntity codigotipodocumento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigorol", nullable = false)
    private RolusuarioEntity codigorol;

    @Column(name = "nombreusuario", nullable = false, length = 100)
    private String nombreusuario;

    @Column(name = "razonsolcial", length = 100)
    private String razonsolcial;

    @Column(name = "telefono", nullable = false)
    private Long telefono;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "contrasena", nullable = false, length = 200)
    private String contrasena;

    @Column(name = "activo", nullable = false)
    private Integer activo;

    @Column(name = "aprobadofunc")
    private Integer aprobadofunc;

    public Integer getAprobadofunc() {
        return aprobadofunc;
    }

    public void setAprobadofunc(Integer aprobadofunc) {
        this.aprobadofunc = aprobadofunc;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getRazonsolcial() {
        return razonsolcial;
    }

    public void setRazonsolcial(String razonsolcial) {
        this.razonsolcial = razonsolcial;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public RolusuarioEntity getCodigorol() {
        return codigorol;
    }

    public void setCodigorol(RolusuarioEntity codigorol) {
        this.codigorol = codigorol;
    }

    public TipodocumentoEntity getCodigotipodocumento() {
        return codigotipodocumento;
    }

    public void setCodigotipodocumento(TipodocumentoEntity codigotipodocumento) {
        this.codigotipodocumento = codigotipodocumento;
    }

    public BarrioEntity getCodigobarrio() {
        return codigobarrio;
    }

    public void setCodigobarrio(BarrioEntity codigobarrio) {
        this.codigobarrio = codigobarrio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}