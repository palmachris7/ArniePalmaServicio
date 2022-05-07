package com.idat.microservicioidatio.service;

import com.idat.microservicioidatio.model.Profesor;
import com.idat.microservicioidatio.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    private ProfesorRepository repository;
    @Override
    public List<Profesor> listar() {
        return repository.findAll();
    }

    @Override
    public void guardarProfesor(Profesor p) {
        Profesor profesor = new Profesor();
        profesor.setIdProfesor(p.getIdProfesor());
        profesor.setNombreProfesor(p.getNombreProfesor());
        profesor.setCurso(p.getCurso());
        repository.save(profesor);
    }

    @Override
    public void eliminarProfesor(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void editarProfesor(Profesor p) {
        repository.saveAndFlush(p);
    }

    @Override
    public Profesor ProfesorbyId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
