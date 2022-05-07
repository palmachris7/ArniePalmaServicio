package com.idat.microservicioidatio.service;

import com.idat.microservicioidatio.model.Estudiante;
import com.idat.microservicioidatio.model.Profesor;
import org.springframework.stereotype.Service;


import java.util.List;

public interface EstudianteService {
    List<Estudiante> listar();
    void guardarEstudiante(Estudiante p);
    void eliminarEstudiante(Integer id);
    void editarEstudiante(Estudiante e);
    Estudiante EstudiantebyId(Integer id);
}
