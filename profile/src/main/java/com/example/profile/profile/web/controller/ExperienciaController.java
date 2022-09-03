package com.example.profile.profile.web.controller;

import com.example.profile.profile.domain.entities.Experiencia;
import com.example.profile.profile.domain.services.ExperienciaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaService service;

    @GetMapping("/all")
    @ApiOperation(value = "Get all type documents")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<Experiencia>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar la experiencia laboral de un usuario por Id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "NOT FOUND")
    })
    public ResponseEntity<Experiencia> getExperienciaById(@PathVariable("id") int id){
        return service.getExperienciaById(id).map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
                orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteExperienciaById(@PathVariable("id") int id){
        if(service.deleteExperienciaById(id) == true){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Experiencia> saveExperiencia(@RequestBody Experiencia experiencia){
        return new ResponseEntity<>(service.saveExperiencia(experiencia),HttpStatus.CREATED);
    }

}
