package com.example.profile.profile.web.controller;

import com.example.profile.profile.domain.entities.Educacion;
import com.example.profile.profile.domain.services.EducacionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educacion")
public class EducacionController {

    @Autowired
    private EducacionService service;

    @GetMapping("/all")
    @ApiOperation(value = "Obtener todos los estudios realizados ")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<Educacion>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar un estudio del un usuario por Id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "NOT FOUND")
    })
    public ResponseEntity<Educacion> getEducacionById(@PathVariable("id") int id){
        return service.getEducacionById(id).map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
                orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteEducacionById(@PathVariable("id") int id){
        if(service.deleteEducacionById(id) == true){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Educacion> saveEducacion(@RequestBody Educacion educacion){
        return new ResponseEntity<>(service.saveEducacion(educacion),HttpStatus.CREATED);
    }

}
