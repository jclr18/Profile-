package com.example.profile.profile.domain.entities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Perfil {

    private int idPerfil;
    private String resumen;
    private String estado;

    private int idUsuario;

    private Usuario usuarioPer;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuarioPer() {
        return usuarioPer;
    }

    public void setUsuarioPer(Usuario usuarioPer) {
        this.usuarioPer = usuarioPer;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
