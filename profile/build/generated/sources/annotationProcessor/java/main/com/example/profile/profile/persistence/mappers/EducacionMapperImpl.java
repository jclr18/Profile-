package com.example.profile.profile.persistence.mappers;

import com.example.profile.profile.domain.entities.Educacion;
import com.example.profile.profile.persistence.models.EducacionDAO;
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
public class EducacionMapperImpl implements EducacionMapper {

    @Override
    public Educacion toEducacion(EducacionDAO dao) {
        if ( dao == null ) {
            return null;
        }

        Educacion educacion = new Educacion();

        educacion.setIdEducacion( dao.getIdEducacion() );
        educacion.setCarrera( dao.getCarrera() );
        educacion.setInstitucion( dao.getInstitucion() );
        educacion.setFechaInicio( dao.getFechaInicio() );
        educacion.setFechaFin( dao.getFechaFin() );
        educacion.setIdUsuario( dao.getIdUsuario() );

        return educacion;
    }

    @Override
    public List<Educacion> toEducaciones(List<EducacionDAO> daos) {
        if ( daos == null ) {
            return null;
        }

        List<Educacion> list = new ArrayList<Educacion>( daos.size() );
        for ( EducacionDAO educacionDAO : daos ) {
            list.add( toEducacion( educacionDAO ) );
        }

        return list;
    }

    @Override
    public EducacionDAO toEducacionDAO(Educacion educacion) {
        if ( educacion == null ) {
            return null;
        }

        EducacionDAO educacionDAO = new EducacionDAO();

        educacionDAO.setIdEducacion( educacion.getIdEducacion() );
        educacionDAO.setCarrera( educacion.getCarrera() );
        educacionDAO.setInstitucion( educacion.getInstitucion() );
        educacionDAO.setFechaInicio( educacion.getFechaInicio() );
        educacionDAO.setFechaFin( educacion.getFechaFin() );
        educacionDAO.setIdUsuario( educacion.getIdUsuario() );

        return educacionDAO;
    }
}
