package com.idat.microservicioidatio.service;

import com.idat.microservicioidatio.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> listar();
    void guardarCliente(Cliente p);
   void eliminarCliente(Integer id);
    void editarCliente(Cliente p);
     Cliente ClientebyId(Integer id);
}
