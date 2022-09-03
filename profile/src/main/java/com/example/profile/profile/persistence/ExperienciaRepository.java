package com.example.profile.profile.persistence;

import com.example.profile.profile.domain.entities.Experiencia;
import com.example.profile.profile.domain.gateways.ExperienciaGateway;
import com.example.profile.profile.persistence.crud.ExperienciaCrudRepository;
import com.example.profile.profile.persistence.mappers.ExperienciaMapper;
import com.example.profile.profile.persistence.models.ExperienciaDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExperienciaRepository implements ExperienciaGateway {

    private ExperienciaCrudRepository crudRepository;

    private ExperienciaMapper mapper ;

    public ExperienciaRepository(ExperienciaCrudRepository crudRepository, ExperienciaMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Experiencia> getAll() {
        List<ExperienciaDAO> daos = (List<ExperienciaDAO>) crudRepository.findAll();
        List<Experiencia> experienciaList = mapper.toExperiencias(daos);
        return experienciaList;
    }

    @Override
    public Optional<Experiencia> getExperienciaById(int id) {
        return crudRepository.findById(id).map(td -> mapper.toExperiencia(td));
    }

    @Override
    public Experiencia saveExperiencia(Experiencia experiencia) {
        ExperienciaDAO dao = mapper.toExperienciaDAO(experiencia);
        return mapper.toExperiencia(crudRepository.save(dao));
    }

    @Override
    public void deleteExperiencia(int id) {
        crudRepository.deleteById(id);
    }

}
