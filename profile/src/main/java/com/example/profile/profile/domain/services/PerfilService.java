package com.example.profile.profile.domain.services;

import com.example.profile.profile.domain.entities.Perfil;
import com.example.profile.profile.domain.gateways.PerfilGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilGateway gateway;

    public List<Perfil> getAll(){
        return gateway.getAll();
    }

    public Optional<Perfil> getPerfilById(int id ) {
        return gateway.getPerfilById(id);
    }

    public Perfil savePerfil(Perfil perfil){
        return gateway.savePerfil(perfil);
    }

    public boolean deletePerfilById(int id){
        return getPerfilById(id).map(td -> {
            gateway.deletePerfil(id);
            return true;
        }).orElse(false);
    }

    // buscar usuario por tecnologia
    public Optional<List<Perfil>> getContainingTecnology(String resumen){

        return gateway.getUserContainingTecnology(resumen);
    }



}
