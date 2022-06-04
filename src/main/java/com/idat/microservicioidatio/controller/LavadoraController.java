package com.idat.microservicioidatio.controller;



import com.idat.microservicioidatio.model.Lavadora;
import com.idat.microservicioidatio.service.LavadoraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lavadora/v1")
public class LavadoraController {
    @Autowired
    private LavadoraService service;

    @GetMapping(path= "/listar")
    public @ResponseBody
    List<Lavadora> listar(){
        return service.listar();
    }

    @PostMapping(path = "guardar")
    public ResponseEntity<Void> guardar(@RequestBody Lavadora lavadora){
        service.guardarLavadora(lavadora);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/listar/{id}")
    public @ResponseBody ResponseEntity<Lavadora> LavadoraById(@PathVariable Integer id){
        Lavadora lavadora = service.LavadorabyId(id);
        if(lavadora != null) {
            return new ResponseEntity<Lavadora>(lavadora, HttpStatus.OK);

        }
        return new ResponseEntity<Lavadora>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        Lavadora lavadora = service.LavadorabyId(id);
        if(lavadora != null) {
            service.eliminarLavadora(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
    @PutMapping(path = "/editar")
    public ResponseEntity<Void> editar(@RequestBody Lavadora lavadora){
        Lavadora lavad = service.LavadorabyId(lavadora.getIdLavadora());
        if(lavad != null) {
            service.editarLavadora(lavadora);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
