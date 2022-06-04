package com.idat.microservicioidatio.controller;


import com.idat.microservicioidatio.model.Ropa;
import com.idat.microservicioidatio.service.RopaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ropa/v1")
public class RopaController {
    @Autowired
    private RopaService service;

    @GetMapping(path= "/listar")
    public @ResponseBody
    List<Ropa> listar(){
        return service.listar();
    }

    @PostMapping(path = "guardar")
    public ResponseEntity<Void> guardar(@RequestBody Ropa ropa){
        service.guardarRopa(ropa);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/listar/{id}")
    public @ResponseBody ResponseEntity<Ropa> RopaById(@PathVariable Integer id){
        Ropa ropa = service.RopabyId(id);
        if(ropa != null) {
            return new ResponseEntity<Ropa>(ropa, HttpStatus.OK);

        }
        return new ResponseEntity<Ropa>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        Ropa ropa = service.RopabyId(id);
        if(ropa != null) {
            service.eliminarRopa(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
    @PutMapping(path = "/editar")
    public ResponseEntity<Void> editar(@RequestBody Ropa ropa){
        Ropa rop = service.RopabyId(ropa.getIdRopa());
        if(rop != null) {
            service.editarRopa(ropa);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
