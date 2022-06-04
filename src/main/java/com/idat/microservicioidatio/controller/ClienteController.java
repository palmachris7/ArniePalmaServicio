package com.idat.microservicioidatio.controller;


import com.idat.microservicioidatio.model.Cliente;

import com.idat.microservicioidatio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente/v1")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping(path= "/listar")
    public @ResponseBody
    List<Cliente> listar(){
        return service.listar();
    }

    @PostMapping(path = "guardar")
    public ResponseEntity<Void> guardar(@RequestBody Cliente cliente){
        service.guardarCliente(cliente);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/listar/{id}")
    public @ResponseBody ResponseEntity<Cliente> ClientebyId(@PathVariable Integer id){
        Cliente cliente = service.ClientebyId(id);
        if(cliente != null) {
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);

        }
        return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        Cliente cliente = service.ClientebyId(id);
        if(cliente != null) {
            service.eliminarCliente(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

    }
    @PutMapping(path = "/editar")
    public ResponseEntity<Void> editar(@RequestBody Cliente cliente){
        Cliente profe = service.ClientebyId(cliente.getIdCliente());
        if(profe != null) {
            service.editarCliente(cliente);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
