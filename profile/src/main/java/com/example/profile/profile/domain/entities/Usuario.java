package com.example.profile.profile.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class Usuario {

    private int usuarioId;
    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String pais;
    private String email;
    private int edad;

    private List<Experiencia> experiencias;

    private List<Educacion> educaciones;

   
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaNacimiento;
    private String cambioResidencia;

    // años de experiencia
    private int experiencia;

    public List<Educacion> getEducaciones() {
        return educaciones;
    }

    public void setEducaciones(List<Educacion> educaciones) {
        this.educaciones = educaciones;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCambioResidencia() {
        return cambioResidencia;
    }

    public void setCambioResidencia(String cambioResidencia) {
        this.cambioResidencia = cambioResidencia;
    }
}
