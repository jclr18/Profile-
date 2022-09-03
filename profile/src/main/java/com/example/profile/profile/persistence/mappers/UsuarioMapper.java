package com.example.profile.profile.persistence.mappers;

import com.example.profile.profile.domain.entities.Usuario;
import com.example.profile.profile.persistence.models.UsuarioDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {EducacionMapper.class,ExperienciaMapper.class} )
public interface UsuarioMapper {

    @Mappings({
            @Mapping(source = "idUsuario",target = "usuarioId"),
            @Mapping(source = "nombre",target = "nombre"),
            @Mapping(source = "apellido",target = "apellido"),
            @Mapping(source = "direccion",target = "direccion"),
            @Mapping(source = "ciudad",target = "ciudad"),
            @Mapping(source = "pais",target = "pais"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "edad",target = "edad"),
            @Mapping(source = "experiencia",target = "experiencia"),
            @Mapping(source = "cambioResidencia",target = "cambioResidencia"),
            @Mapping(source = "fechaNacimiento",target = "fechaNacimiento")
            //@Mapping(source = "experiencias",target = "experiencias"),
            //@Mapping(source = "educaciones",target = "educaciones")


    })
    Usuario toUsuario(UsuarioDAO dao);

    List<Usuario> toUsuarios(List<UsuarioDAO> daos);

    @InheritInverseConfiguration
    @Mapping(target = "perfil",ignore = true )
    @Mapping(target = "experiencias",ignore = true )
    @Mapping(target = "educaciones",ignore = true )
    UsuarioDAO toUsuarioDAO(Usuario usuario);



}
