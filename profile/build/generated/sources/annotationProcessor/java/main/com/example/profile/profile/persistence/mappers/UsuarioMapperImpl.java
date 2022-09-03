package com.example.profile.profile.persistence.mappers;

import com.example.profile.profile.domain.entities.Usuario;
import com.example.profile.profile.persistence.models.UsuarioDAO;
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
public class UsuarioMapperImpl implements UsuarioMapper {

    @Autowired
    private EducacionMapper educacionMapper;
    @Autowired
    private ExperienciaMapper experienciaMapper;

    @Override
    public Usuario toUsuario(UsuarioDAO dao) {
        if ( dao == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        if ( dao.getIdUsuario() != null ) {
            usuario.setUsuarioId( dao.getIdUsuario() );
        }
        usuario.setNombre( dao.getNombre() );
        usuario.setApellido( dao.getApellido() );
        usuario.setDireccion( dao.getDireccion() );
        usuario.setCiudad( dao.getCiudad() );
        usuario.setPais( dao.getPais() );
        usuario.setEmail( dao.getEmail() );
        usuario.setEdad( dao.getEdad() );
        usuario.setExperiencia( dao.getExperiencia() );
        usuario.setCambioResidencia( dao.getCambioResidencia() );
        usuario.setFechaNacimiento( dao.getFechaNacimiento() );
        usuario.setEducaciones( educacionMapper.toEducaciones( dao.getEducaciones() ) );
        usuario.setExperiencias( experienciaMapper.toExperiencias( dao.getExperiencias() ) );

        return usuario;
    }

    @Override
    public List<Usuario> toUsuarios(List<UsuarioDAO> daos) {
        if ( daos == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( daos.size() );
        for ( UsuarioDAO usuarioDAO : daos ) {
            list.add( toUsuario( usuarioDAO ) );
        }

        return list;
    }

    @Override
    public UsuarioDAO toUsuarioDAO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuarioDAO.setIdUsuario( usuario.getUsuarioId() );
        usuarioDAO.setNombre( usuario.getNombre() );
        usuarioDAO.setApellido( usuario.getApellido() );
        usuarioDAO.setDireccion( usuario.getDireccion() );
        usuarioDAO.setCiudad( usuario.getCiudad() );
        usuarioDAO.setPais( usuario.getPais() );
        usuarioDAO.setEmail( usuario.getEmail() );
        usuarioDAO.setEdad( usuario.getEdad() );
        usuarioDAO.setExperiencia( usuario.getExperiencia() );
        usuarioDAO.setCambioResidencia( usuario.getCambioResidencia() );
        usuarioDAO.setFechaNacimiento( usuario.getFechaNacimiento() );

        return usuarioDAO;
    }
}
