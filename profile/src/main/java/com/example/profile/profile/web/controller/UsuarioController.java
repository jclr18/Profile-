package com.example.profile.profile.web.controller;

import com.example.profile.profile.domain.entities.Usuario;
import com.example.profile.profile.domain.services.UsuarioService;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/all")
    @ApiOperation(value = "Obtener todos los usuarios ")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<Usuario>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar un usuario por Id")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK"),
            @ApiResponse(code = 404,message = "NOT FOUND")
    })
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") int id){
        return service.getUsuarioById(id).map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
                orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUsuarioById(@PathVariable("id") int id){
        if(service.deleteUsuarioById(id) == true){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

   @PostMapping("/save")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(service.saveUsuario(usuario),HttpStatus.CREATED);
    }

    @GetMapping("/greaterThanEquals/{experiencia}")
    public ResponseEntity<Optional<List<Usuario>>> getGreaterThanEquals(@PathVariable("experiencia") int experiencia){
        return new ResponseEntity<>(service.getGreaterThanEqual(experiencia), HttpStatus.OK);
    }

    @GetMapping("/Containings/{ciudad}")
    public ResponseEntity<Optional<List<Usuario>>> getContainings(@PathVariable("ciudad") String ciudad){
        return new ResponseEntity<>(service.getContaining(ciudad), HttpStatus.OK);
    }

    @GetMapping("/CambioResidencias/{cambioResidencia}")
    public ResponseEntity<Optional<List<Usuario>>> getCambioResidencias(@PathVariable("cambioResidencia") String cambioResidencia){
        return new ResponseEntity<>(service.getIgnoreCase(cambioResidencia), HttpStatus.OK);
    }

    @GetMapping("/estudios/{carrera}")
    public ResponseEntity<Optional<List<Usuario>>> getContainingStudy(@PathVariable("carrera") String carrera){
        return new ResponseEntity<>(service.getContainingStudy(carrera), HttpStatus.OK);
    }

}
