package com.example.profile.profile.persistence.mappers;

import com.example.profile.profile.domain.entities.Perfil;
import com.example.profile.profile.persistence.models.PerfilDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-01T17:55:55-0400",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class PerfilMapperImpl implements PerfilMapper {

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public Perfil toPerfil(PerfilDAO dao) {
        if ( dao == null ) {
            return null;
        }

        Perfil perfil = new Perfil();

        perfil.setIdPerfil( dao.getIdPerfil() );
        perfil.setResumen( dao.getResumen() );
        perfil.setEstado( String.valueOf( dao.isEstado() ) );
        perfil.setIdUsuario( dao.getIdUsuario() );
        perfil.setUsuarioPer( usuarioMapper.toUsuario( dao.getUsuarioPer() ) );

        return perfil;
    }

    @Override
    public List<Perfil> toPerfiles(List<PerfilDAO> daos) {
        if ( daos == null ) {
            return null;
        }

        List<Perfil> list = new ArrayList<Perfil>( daos.size() );
        for ( PerfilDAO perfilDAO : daos ) {
            list.add( toPerfil( perfilDAO ) );
        }

        return list;
    }

    @Override
    public PerfilDAO toPerfilDAO(Perfil perfil) {
        if ( perfil == null ) {
            return null;
        }

        PerfilDAO perfilDAO = new PerfilDAO();

        perfilDAO.setIdPerfil( perfil.getIdPerfil() );
        perfilDAO.setResumen( perfil.getResumen() );
        if ( perfil.getEstado() != null ) {
            perfilDAO.setEstado( Boolean.parseBoolean( perfil.getEstado() ) );
        }
        perfilDAO.setIdUsuario( perfil.getIdUsuario() );

        return perfilDAO;
    }
}
