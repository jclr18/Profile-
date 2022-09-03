package com.example.profile.profile.domain.gateways;

import com.example.profile.profile.domain.entities.Educacion;

import java.util.List;
import java.util.Optional;

public interface EducacionGateway {

    List<Educacion> getAll();
    Optional<Educacion> getEducacionById(int id);
    Educacion saveEducacion(Educacion educacion);
    void deleteEducacion(int id);

}
