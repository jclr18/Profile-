package com.example.profile.profile.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class Educacion {

    private int idEducacion;
    private String carrera;
    private String institucion;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaInicio;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaFin;
    private int idUsuario;


    public int getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(int idEducacion) {
        this.idEducacion = idEducacion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


}
