package com.sofkau.util;

public class Usuario {

    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String estado;
    private String codigoZip;
    private String telefono;
    private String ssn;
    private String nombreUsuario;
    private String contrasena;
    private String confirmaContrasena;

    public Usuario(String nombre, String apellido, String direccion, String ciudad, String estado, String codigoZip, String telefono, String ssn, String nombreUsuario, String contrasena, String confirmaContrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoZip = codigoZip;
        this.telefono = telefono;
        this.ssn = ssn;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.confirmaContrasena = confirmaContrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoZip() {
        return codigoZip;
    }

    public void setCodigoZip(String codigoZip) {
        this.codigoZip = codigoZip;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmaContrasena() {
        return confirmaContrasena;
    }

    public void setConfirmaContrasena(String confirmaContrasena) {
        this.confirmaContrasena = confirmaContrasena;
    }
}
