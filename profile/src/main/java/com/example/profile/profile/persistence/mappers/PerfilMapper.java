package com.example.profile.profile.persistence.mappers;

import com.example.profile.profile.domain.entities.Perfil;
import com.example.profile.profile.persistence.models.PerfilDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UsuarioMapper.class})
public interface PerfilMapper {

    @Mappings({
            @Mapping(source = "idPerfil",target = "idPerfil"),
            @Mapping(source = "resumen",target = "resumen"),
            @Mapping(source = "estado",target = "estado"),
            @Mapping(source = "idUsuario",target = "idUsuario")

    })

    Perfil toPerfil(PerfilDAO dao);
    List<Perfil> toPerfiles(List<PerfilDAO> daos);

    @InheritInverseConfiguration
    @Mapping(target = "usuarioPer",ignore = true )
    PerfilDAO toPerfilDAO(Perfil perfil);
}
