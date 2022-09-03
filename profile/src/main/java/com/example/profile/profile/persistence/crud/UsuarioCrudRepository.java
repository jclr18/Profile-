package com.example.profile.profile.persistence.crud;

import com.example.profile.profile.persistence.models.UsuarioDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<UsuarioDAO,Integer>{

    Optional<List<UsuarioDAO>> findByExperienciaGreaterThanEqualOrderByExperienciaAsc(int experiencia);
    Optional<List<UsuarioDAO>> findByCiudadContaining(String ciudad);

    Optional<List<UsuarioDAO>> findByCambioResidenciaIgnoreCase(String cambioResidencia);

    @Query(value = "select * from usuarios u join educacion ur on u.id_usuario = ur.id_usuario where carrera like  :carrera", nativeQuery=true)
    Optional<List<UsuarioDAO>>  findByIdUsuarioAndCarrera(String carrera);



}
