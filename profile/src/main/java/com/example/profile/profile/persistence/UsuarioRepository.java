package com.example.profile.profile.persistence;

import com.example.profile.profile.domain.entities.Usuario;
import com.example.profile.profile.domain.gateways.UsuarioGateway;
import com.example.profile.profile.persistence.crud.UsuarioCrudRepository;
import com.example.profile.profile.persistence.mappers.UsuarioMapper;
import com.example.profile.profile.persistence.models.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class UsuarioRepository implements UsuarioGateway {

    @Autowired
    private UsuarioCrudRepository crudRepository;
    @Autowired
    private UsuarioMapper mapper ;


    @Override
    public List<Usuario> getAll() {
        List<UsuarioDAO> usuarios = (List<UsuarioDAO>) crudRepository.findAll();
        return mapper.toUsuarios(usuarios);
    }

    @Override
    public Optional<Usuario> getUsuarioById(int id) {
        return crudRepository.findById(id).map(td -> mapper.toUsuario(td));
    }


    @Override
    public Usuario saveUsuario(Usuario usuario) {
        UsuarioDAO dao = mapper.toUsuarioDAO(usuario);
        return mapper.toUsuario(crudRepository.save(dao));
    }

    @Override
    public void deleteUsuario(int id) {
        crudRepository.deleteById(id);
    }

    @Override
    public Optional<List<Usuario>> getUserGreaterThanEqual(int experiencia) {
        Optional<List<UsuarioDAO>> userDAO = crudRepository.findByExperienciaGreaterThanEqualOrderByExperienciaAsc(experiencia);
        return Optional.of(mapper.toUsuarios(userDAO.get()));
    }

    @Override
    public Optional<List<Usuario>> getUserContaining(String ciudad) {
        Optional<List<UsuarioDAO>> userDAO = crudRepository.findByCiudadContaining(ciudad);
        return Optional.of(mapper.toUsuarios(userDAO.get()));
    }

    @Override
    public Optional<List<Usuario>> getCambioResidenciaIgnoreCase(String cambioResidencia) {
        Optional<List<UsuarioDAO>> userDAO = crudRepository.findByCambioResidenciaIgnoreCase(cambioResidencia);
        return Optional.of(mapper.toUsuarios(userDAO.get()));
    }

    @Override
    public Optional<List<Usuario>> getUserContainingStudy(String carrera) {
        Optional<List<UsuarioDAO>> userDAO = crudRepository.findByIdUsuarioAndCarrera(carrera);
        return Optional.of(mapper.toUsuarios(userDAO.get()));
    }


}
