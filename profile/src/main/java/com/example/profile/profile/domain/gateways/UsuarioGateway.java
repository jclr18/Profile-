package com.example.profile.profile.domain.gateways;

import com.example.profile.profile.domain.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioGateway {

    List<Usuario> getAll();
    Optional<Usuario> getUsuarioById(int id);

    Usuario saveUsuario(Usuario usuario);
    void deleteUsuario(int id);

    //buscar usuario por año de experiencia
    Optional<List<Usuario>> getUserGreaterThanEqual(int experiencia);

    // buscar usuarios por ciudad
    Optional<List<Usuario>> getUserContaining(String ciudad);

    // buscar usuarios que pueden cambiar de residencia
    Optional<List<Usuario>> getCambioResidenciaIgnoreCase(String cambioResidencia);

    // buscar estudios
     Optional<List<Usuario>> getUserContainingStudy(String carrera);

}
