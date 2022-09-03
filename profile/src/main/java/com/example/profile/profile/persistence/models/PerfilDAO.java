package com.example.profile.profile.persistence.models;

import javax.persistence.*;

@Entity
@Table(name = "perfil")
public class PerfilDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private int idPerfil;

    private String resumen;
    private boolean estado;

    @Column(name = "id_usuario")
    private int idUsuario;



    @OneToOne
    @JoinColumn(name="id_usuario", insertable = false,updatable = false)
    private UsuarioDAO usuarioPer;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public UsuarioDAO getUsuarioPer() {
        return usuarioPer;
    }

    public void setUsuarioPer(UsuarioDAO usuarioPer) {
        this.usuarioPer = usuarioPer;
    }
}
