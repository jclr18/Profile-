package com.example.profile.profile.persistence;

import com.example.profile.profile.domain.entities.Educacion;
import com.example.profile.profile.domain.gateways.EducacionGateway;
import com.example.profile.profile.persistence.crud.EducacionCrudRepository;
import com.example.profile.profile.persistence.mappers.EducacionMapper;
import com.example.profile.profile.persistence.models.EducacionDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EducacionRepository implements EducacionGateway {

    private EducacionCrudRepository crudRepository;

    private EducacionMapper mapper ;

    public EducacionRepository(EducacionCrudRepository crudRepository, EducacionMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Educacion> getAll() {
        List<EducacionDAO> daos = (List<EducacionDAO>) crudRepository.findAll();
        List<Educacion> educacionList = mapper.toEducaciones(daos);
        return educacionList;
    }

    @Override
    public Optional<Educacion> getEducacionById(int id) {
        return crudRepository.findById(id).map(td -> mapper.toEducacion(td));
    }

    @Override
    public Educacion saveEducacion(Educacion educacion) {
        EducacionDAO dao = mapper.toEducacionDAO(educacion);
        return mapper.toEducacion(crudRepository.save(dao));
    }

    @Override
    public void deleteEducacion(int id) {
        crudRepository.deleteById(id);
    }

}
