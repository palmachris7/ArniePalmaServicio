package com.idat.microservicioidatio.service;

import com.idat.microservicioidatio.model.Cliente;
import com.idat.microservicioidatio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @Override
    public void guardarCliente(Cliente p) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(p.getIdCliente());
        cliente.setNombreCliente(p.getNombreCliente());
        cliente.setApellidoCliente(p.getApellidoCliente());
        cliente.setDireccion(p.getDireccion());
        cliente.setNrocelular(p.getNrocelular());
        repository.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void editarCliente(Cliente p) {
        repository.saveAndFlush(p);
    }

    @Override
    public Cliente ClientebyId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
