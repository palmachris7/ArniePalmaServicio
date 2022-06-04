package com.idat.microservicioidatio.service;

import com.idat.microservicioidatio.model.Ropa;
import com.idat.microservicioidatio.repository.RopaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RopaServiceImpl implements RopaService {
    @Autowired
    private RopaRepository repository;
    @Override
    public List<Ropa> listar(){
        return repository.findAll();
    }

    @Override
    public void guardarRopa(Ropa p) {
        Ropa ropa = new Ropa();
        ropa.setIdRopa(p.getIdRopa());
        ropa.setTipoRopa(p.getTipoRopa());
        ropa.setDescripcion(p.getDescripcion());
        repository.save(ropa);
    }

    @Override
    public void eliminarRopa(Integer id) {
        repository.deleteById(id);
    }



    @Override
    public void editarRopa(Ropa e) {
        repository.saveAndFlush(e);
    }

    @Override
    public Ropa RopabyId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
