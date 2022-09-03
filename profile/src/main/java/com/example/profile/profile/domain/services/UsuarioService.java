package com.example.profile.profile.domain.services;

import com.example.profile.profile.domain.entities.Usuario;
import com.example.profile.profile.domain.gateways.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioGateway gateway;

    public List<Usuario> getAll(){
        return gateway.getAll();
    }

    public Optional<Usuario> getUsuarioById(int id ) {
        return gateway.getUsuarioById(id);
    }

   public Usuario saveUsuario(Usuario usuario){
        return gateway.saveUsuario(usuario);
    }

    public boolean deleteUsuarioById(int id){
        return getUsuarioById(id).map(td -> {
            gateway.deleteUsuario(id);
            return true;
        }).orElse(false);
    }

    // buscar por año de experiencia en usuarios
    public Optional<List<Usuario>> getGreaterThanEqual(int experiencia){

        return gateway.getUserGreaterThanEqual(experiencia);
    }

    // buscar usuario por ciudad
    public Optional<List<Usuario>> getContaining(String ciudad){

        return gateway.getUserContaining(ciudad);
    }

    // buscar usuario que pueden cambiar de residencia
    public Optional<List<Usuario>> getIgnoreCase(String cambioResidencia){

        return gateway.getCambioResidenciaIgnoreCase(cambioResidencia);
    }

    // buscar estudios  por usuarios
      public Optional<List<Usuario>> getContainingStudy(String carrera){
        return gateway.getUserContainingStudy(carrera);
     }

}
