package com.idat.microservicioidatio.service;

import com.idat.microservicioidatio.model.Lavadora;
import com.idat.microservicioidatio.repository.LavadoraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LavadoraServiceImpl implements LavadoraService {
    @Autowired
    private LavadoraRepository repository;
    @Override
    public List<Lavadora> listar() {
        return repository.findAll();
    }

    @Override
    public void guardarLavadora(Lavadora p) {
        Lavadora lavadora = new Lavadora();
        lavadora.setIdLavadora(p.getIdLavadora());
        lavadora.setDescripcion(p.getDescripcion());
        lavadora.setMarca(p.getMarca());
        lavadora.setVoltaje(p.getVoltaje());
        repository.save(lavadora);
    }

    @Override
    public void eliminarLavadora(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void editarLavadora(Lavadora p) {
        repository.saveAndFlush(p);
    }

    @Override
    public Lavadora LavadorabyId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
