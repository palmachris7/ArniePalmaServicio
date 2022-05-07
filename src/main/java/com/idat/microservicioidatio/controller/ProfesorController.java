package com.idat.microservicioidatio.controller;


import com.idat.microservicioidatio.model.Profesor;

import com.idat.microservicioidatio.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profesor/v1")
public class ProfesorController {
    @Autowired
    private ProfesorService service;

    @GetMapping(path= "/listar")
    public @ResponseBody
    List<Profesor> listar(){
        return service.listar();
    }

    @PostMapping(path = "guardar")
    public ResponseEntity<Void> guardar(@RequestBody Profesor profesor){
        service.guardarProfesor(profesor);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/listar/{id}")
    public @ResponseBody ResponseEntity<Profesor> ProfesorById(@PathVariable Integer id){
        Profesor profesor = service.ProfesorbyId(id);
        if(profesor != null) {
            return new ResponseEntity<Profesor>(profesor, HttpStatus.OK);

        }
        return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        Profesor profesor = service.ProfesorbyId(id);
        if(profesor != null) {
            service.eliminarProfesor(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
    @PutMapping(path = "/editar")
    public ResponseEntity<Void> editar(@RequestBody Profesor profesor){
        Profesor profe = service.ProfesorbyId(profesor.getIdProfesor());
        if(profe != null) {
            service.editarProfesor(profesor);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
