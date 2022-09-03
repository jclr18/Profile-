package com.example.profile.profile.domain.gateways;

import com.example.profile.profile.domain.entities.Perfil;

import java.util.List;
import java.util.Optional;

public interface PerfilGateway {

    List<Perfil> getAll();
    Optional<Perfil> getPerfilById(int id);
    Perfil savePerfil(Perfil perfil);
    void deletePerfil(int id);

    // buscar usuarios por tecnologia
    Optional<List<Perfil>> getUserContainingTecnology(String resumen);


}
