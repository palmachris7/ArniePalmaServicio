package com.idat.microservicioidatio.service;

import com.idat.microservicioidatio.model.Estudiante;
import com.idat.microservicioidatio.model.Profesor;
import com.idat.microservicioidatio.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteServiceImpl implements EstudianteService{
    @Autowired
    private EstudianteRepository repository;
    @Override
    public List<Estudiante> listar(){
        return repository.findAll();
    }

    @Override
    public void guardarEstudiante(Estudiante p) {
        Estudiante estudiante = new Estudiante();
        estudiante.setIdEstudiante(p.getIdEstudiante());
        estudiante.setNombreEstudiante(p.getNombreEstudiante());
        repository.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Integer id) {
        repository.deleteById(id);
    }



    @Override
    public void editarEstudiante(Estudiante e) {
        repository.saveAndFlush(e);
    }

    @Override
    public Estudiante EstudiantebyId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
