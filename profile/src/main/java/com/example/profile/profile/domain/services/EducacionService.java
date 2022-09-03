package com.example.profile.profile.domain.services;

import com.example.profile.profile.domain.entities.Educacion;
import com.example.profile.profile.domain.gateways.EducacionGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducacionService {

    @Autowired
    private EducacionGateway gateway;

    public List<Educacion> getAll(){
        return gateway.getAll();
    }

    public Optional<Educacion> getEducacionById(int id ) {
        return gateway.getEducacionById(id);
    }

    public Educacion saveEducacion(Educacion educacion){
        return gateway.saveEducacion(educacion);
    }

    public boolean deleteEducacionById(int id){
        return getEducacionById(id).map(td -> {
            gateway.deleteEducacion(id);
            return true;
        }).orElse(false);
    }


}
