package com.example.profile.profile.persistence.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "educacion")
public class EducacionDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_educacion")
    private int idEducacion;

    private String carrera;
    private String institucion;

    //@JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "id_usuario")
    private int idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario",insertable = false,updatable = false, foreignKey = @ForeignKey(name = "FK_educacion_usuario"))
    private UsuarioDAO usuarioEdu;

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

    public UsuarioDAO getUsuarioEdu() {
        return usuarioEdu;
    }

    public void setUsuarioEdu(UsuarioDAO usuarioEdu) {
        this.usuarioEdu = usuarioEdu;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
