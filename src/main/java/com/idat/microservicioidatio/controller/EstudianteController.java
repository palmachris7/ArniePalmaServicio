package com.idat.microservicioidatio.controller;

import com.idat.microservicioidatio.model.Estudiante;
import com.idat.microservicioidatio.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudiante/v1")
public class EstudianteController {
    @Autowired
    private EstudianteService service;

    @GetMapping(path= "/listar")
    public @ResponseBody
    List<Estudiante> listar(){
        return service.listar();
    }

    @PostMapping(path = "guardar")
    public ResponseEntity<Void> guardar(@RequestBody Estudiante estudiante){
        service.guardarEstudiante(estudiante);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/listar/{id}")
    public @ResponseBody ResponseEntity<Estudiante> EstudianteById(@PathVariable Integer id){
        Estudiante estudiante = service.EstudiantebyId(id);
        if(estudiante != null) {
            return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);

        }
        return new ResponseEntity<Estudiante>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        Estudiante estudiante = service.EstudiantebyId(id);
        if(estudiante != null) {
            service.eliminarEstudiante(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
    @PutMapping(path = "/editar")
    public ResponseEntity<Void> editar(@RequestBody Estudiante estudiante){
        Estudiante estudent = service.EstudiantebyId(estudiante.getIdEstudiante());
        if(estudent != null) {
            service.editarEstudiante(estudiante);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
