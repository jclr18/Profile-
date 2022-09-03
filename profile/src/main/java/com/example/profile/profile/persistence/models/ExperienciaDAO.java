package com.example.profile.profile.persistence.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "experiencias")
public class ExperienciaDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia")
    private int idExperiencia;

    private String empresa;
    private String cargo;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_fin")
    private Date fechaFin;

    private String descripcion;

    @Column(name = "id_usuario")
    private int idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario",insertable = false,updatable = false, foreignKey = @ForeignKey(name = "FK_experiencia_usuario"))
    private UsuarioDAO usuarioExp;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(int idExperiencia) {
        this.idExperiencia = idExperiencia;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public UsuarioDAO getUsuarioExp() {
        return usuarioExp;
    }

    public void setUsuarioExp(UsuarioDAO usuarioExp) {
        this.usuarioExp = usuarioExp;
    }
}
