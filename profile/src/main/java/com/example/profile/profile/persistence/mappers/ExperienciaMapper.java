package com.example.profile.profile.persistence.mappers;

import com.example.profile.profile.domain.entities.Experiencia;
import com.example.profile.profile.persistence.models.ExperienciaDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExperienciaMapper {

    @Mappings({
            @Mapping(source = "idExperiencia",target = "idExperiencia"),
            @Mapping(source = "empresa",target = "empresa"),
            @Mapping(source = "cargo",target = "cargo"),
            @Mapping(source = "fechaInicio",target = "fechaInicio"),
            @Mapping(source = "fechaFin",target = "fechaFin"),
            @Mapping(source = "descripcion",target = "descripcion"),
            @Mapping(source = "idUsuario",target = "idUsuario")
           // @Mapping(source = "usuarioExp",target = "usuario")
    })

    Experiencia toExperiencia(ExperienciaDAO dao);
    // cast de una lista
    List<Experiencia> toExperiencias(List<ExperienciaDAO> daos);

    // pasar de nuestro dominio a nuestra BD
    // target=users  es para indicar que la lista solo la tiene la BD que ignore ese
    // atributo en el negocio(entities)
    @InheritInverseConfiguration
    @Mapping(target = "usuarioExp",ignore = true )
    ExperienciaDAO toExperienciaDAO(Experiencia experiencia);

}
