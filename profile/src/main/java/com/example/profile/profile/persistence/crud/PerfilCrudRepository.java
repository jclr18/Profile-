package com.example.profile.profile.persistence.crud;

import com.example.profile.profile.persistence.models.PerfilDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PerfilCrudRepository extends CrudRepository<PerfilDAO,Integer> {
    Optional<List<PerfilDAO>> findByResumenContainingAndEstado(String resumen, Boolean estado);


}
