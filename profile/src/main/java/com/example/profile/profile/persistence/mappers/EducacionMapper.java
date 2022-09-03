package com.example.profile.profile.persistence.mappers;

import com.example.profile.profile.domain.entities.Educacion;
import com.example.profile.profile.persistence.models.EducacionDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EducacionMapper {

    @Mappings({
            @Mapping(source = "idEducacion",target = "idEducacion"),
            @Mapping(source = "carrera",target = "carrera"),
            @Mapping(source = "institucion",target = "institucion"),
            @Mapping(source = "fechaInicio",target = "fechaInicio"),
            @Mapping(source = "fechaFin",target = "fechaFin"),
            @Mapping(source = "idUsuario",target = "idUsuario")
         //  @Mapping(source = "usuarioEdu",target = "usuario")
    })

    Educacion toEducacion(EducacionDAO dao);
        // cast de una lista
    List<Educacion> toEducaciones(List<EducacionDAO> daos);

    // pasar de nuestro dominio a nuestra BD
    // target=users  es para indicar que ignore la relacion onetomany pq eso solo para BD
    @InheritInverseConfiguration
    @Mapping(target = "usuarioEdu",ignore = true )
    EducacionDAO toEducacionDAO(Educacion educacion);

}
