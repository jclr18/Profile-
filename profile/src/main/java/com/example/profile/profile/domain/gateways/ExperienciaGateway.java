package com.example.profile.profile.domain.gateways;

import com.example.profile.profile.domain.entities.Experiencia;

import java.util.List;
import java.util.Optional;

public interface ExperienciaGateway {

    List<Experiencia> getAll();
    Optional<Experiencia> getExperienciaById(int id);
    Experiencia saveExperiencia(Experiencia experiencia);
    void deleteExperiencia(int id);
}
