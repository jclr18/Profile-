package com.example.profile.profile.web.controller;

import com.example.profile.profile.domain.entities.Perfil;
import com.example.profile.profile.domain.services.PerfilService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService service;

    @GetMapping("/all")
    @ApiOperation(value = "Obtener todos los perfiless realizados ")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<Perfil>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar un peril de un usuario por Id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "NOT FOUND")
    })
    public ResponseEntity<Perfil> getPerfilById(@PathVariable("id") int id){
        return service.getPerfilById(id).map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
                orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePerfilById(@PathVariable("id") int id){
        if(service.deletePerfilById(id) == true){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Perfil> savePerfil(@RequestBody Perfil perfil){
        return new ResponseEntity<>(service.savePerfil(perfil),HttpStatus.CREATED);
    }

    @GetMapping("/resumenes/{resumen}")
    public ResponseEntity<Optional<List<Perfil>>> getContainingTecnology(@PathVariable("resumen") String resumen){
        return new ResponseEntity<>(service.getContainingTecnology(resumen), HttpStatus.OK);
    }

  //  @GetMapping("/estudios/{carrera}")
  //  public ResponseEntity<Optional<List<Perfil>>> getContainingStudy(@PathVariable("carrera") String carrera){
   //     return new ResponseEntity<>(service.getContainingStudy(carrera), HttpStatus.OK);
   // }

}
