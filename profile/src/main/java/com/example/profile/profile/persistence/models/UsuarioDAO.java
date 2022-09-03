package com.example.profile.profile.persistence.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UsuarioDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int idUsuario;

    private String nombre;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String pais;
    private String email;

    @Positive
    @Min(0)
    @Max(150)
    private int edad;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "cambio_residencia")
    private String cambioResidencia;

    @Positive
    @Min(0)
    @Max(65)
    @Column(name = "experiencia")
    private int experiencia;

    @OneToMany(mappedBy = "usuarioExp", fetch=FetchType.LAZY)
    private List<ExperienciaDAO> experiencias;

    @OneToMany(mappedBy = "usuarioEdu")
    private List<EducacionDAO> educaciones;

    @OneToOne(mappedBy = "usuarioPer")
    private PerfilDAO perfil;

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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






    public String getCambioResidencia() {
        return cambioResidencia;
    }

    public void setCambioResidencia(String cambioResidencia) {
        this.cambioResidencia = cambioResidencia;
    }

    public int getexperiencia() {
        return experiencia;
    }

    public void setexperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

   public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public List<ExperienciaDAO> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<ExperienciaDAO> experiencias) {
        this.experiencias = experiencias;
    }

    public List<EducacionDAO> getEducaciones() {
        return educaciones;
    }

    public void setEducaciones(List<EducacionDAO> educaciones) {
        this.educaciones = educaciones;
    }

    public PerfilDAO getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDAO perfil) {
        this.perfil = perfil;
    }


}
