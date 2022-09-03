package com.example.profile.profile.persistence;

import com.example.profile.profile.domain.entities.Perfil;
import com.example.profile.profile.domain.gateways.PerfilGateway;
import com.example.profile.profile.persistence.crud.PerfilCrudRepository;
import com.example.profile.profile.persistence.mappers.PerfilMapper;
import com.example.profile.profile.persistence.models.PerfilDAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;



@Transactional
@Repository
public class PerfilRepository implements PerfilGateway {

    private PerfilCrudRepository crudRepository;

    private PerfilMapper mapper ;

    public PerfilRepository(PerfilCrudRepository crudRepository, PerfilMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Perfil> getAll() {
        List<PerfilDAO> daos = (List<PerfilDAO>) crudRepository.findAll();
        List<Perfil> perfilList = mapper.toPerfiles(daos);
        return perfilList;
    }

    @Override
    public Optional<Perfil> getPerfilById(int id) {
        return crudRepository.findById(id).map(td -> mapper.toPerfil(td));
    }

    @Override
    public Perfil savePerfil(Perfil perfil) {
        PerfilDAO dao = mapper.toPerfilDAO(perfil);
        return mapper.toPerfil(crudRepository.save(dao));
    }

    @Override
    public void deletePerfil(int id) {
        crudRepository.deleteById(id);
    }

    @Override
    public Optional<List<Perfil>> getUserContainingTecnology(String resumen) {
        Optional<List<PerfilDAO>> userDAO = crudRepository.findByResumenContainingAndEstado(resumen, true);
        return Optional.of(mapper.toPerfiles(userDAO.get()));
    }



}
