package com.example.profile.profile.persistence.mappers;

import com.example.profile.profile.domain.entities.Experiencia;
import com.example.profile.profile.persistence.models.ExperienciaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-01T17:55:55-0400",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class ExperienciaMapperImpl implements ExperienciaMapper {

    @Override
    public Experiencia toExperiencia(ExperienciaDAO dao) {
        if ( dao == null ) {
            return null;
        }

        Experiencia experiencia = new Experiencia();

        experiencia.setIdExperiencia( dao.getIdExperiencia() );
        experiencia.setEmpresa( dao.getEmpresa() );
        experiencia.setCargo( dao.getCargo() );
        experiencia.setFechaInicio( dao.getFechaInicio() );
        experiencia.setFechaFin( dao.getFechaFin() );
        experiencia.setDescripcion( dao.getDescripcion() );
        experiencia.setIdUsuario( dao.getIdUsuario() );

        return experiencia;
    }

    @Override
    public List<Experiencia> toExperiencias(List<ExperienciaDAO> daos) {
        if ( daos == null ) {
            return null;
        }

        List<Experiencia> list = new ArrayList<Experiencia>( daos.size() );
        for ( ExperienciaDAO experienciaDAO : daos ) {
            list.add( toExperiencia( experienciaDAO ) );
        }

        return list;
    }

    @Override
    public ExperienciaDAO toExperienciaDAO(Experiencia experiencia) {
        if ( experiencia == null ) {
            return null;
        }

        ExperienciaDAO experienciaDAO = new ExperienciaDAO();

        experienciaDAO.setIdExperiencia( experiencia.getIdExperiencia() );
        experienciaDAO.setEmpresa( experiencia.getEmpresa() );
        experienciaDAO.setCargo( experiencia.getCargo() );
        experienciaDAO.setFechaInicio( experiencia.getFechaInicio() );
        experienciaDAO.setFechaFin( experiencia.getFechaFin() );
        experienciaDAO.setDescripcion( experiencia.getDescripcion() );
        experienciaDAO.setIdUsuario( experiencia.getIdUsuario() );

        return experienciaDAO;
    }
}
