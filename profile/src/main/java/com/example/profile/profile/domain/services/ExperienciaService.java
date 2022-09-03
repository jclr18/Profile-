package com.example.profile.profile.domain.services;

import com.example.profile.profile.domain.entities.Experiencia;
import com.example.profile.profile.domain.gateways.ExperienciaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaGateway gateway;

    public List<Experiencia> getAll(){
        return gateway.getAll();
    }

    public Optional<Experiencia> getExperienciaById(int id ) {
        return gateway.getExperienciaById(id);
    }

    public Experiencia saveExperiencia(Experiencia experiencia){
        return gateway.saveExperiencia(experiencia);
    }

    public boolean deleteExperienciaById(int id){
        return getExperienciaById(id).map(td -> {
            gateway.deleteExperiencia(id);
            return true;
        }).orElse(false);
    }


}
