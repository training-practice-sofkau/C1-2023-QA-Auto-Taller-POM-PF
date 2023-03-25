package com.sofkau.util;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String email;
    private String genero;
    private String celular;
    private String fechaNacimienti;
    private String materia;
    private String patiempos;
    private String direccion;
    private String estado;
    private String ciudad;

    public Estudiante(String nombre, String apellido, String email, String celular, String fechaNacimienti, String materia, String direccion, String estado, String ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.fechaNacimienti = fechaNacimienti;
        this.materia = materia;
        this.direccion = direccion;
        this.estado = estado;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getGenero() {
        return genero;
    }

    public String getCelular() {
        return celular;
    }

    public String getFechaNacimienti() {
        return fechaNacimienti;
    }

    public String getMateria() {
        return materia;
    }

    public String getPatiempos() {
        return patiempos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEstado() {
        return estado;
    }

    public String getCiudad() {
        return ciudad;
    }
}
