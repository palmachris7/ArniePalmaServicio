package com.idat.microservicioidatio.service;

import com.idat.microservicioidatio.model.Profesor;

import java.util.List;

public interface ProfesorService {
    List<Profesor> listar();
    void guardarProfesor(Profesor p);
   void eliminarProfesor(Integer id);
    void editarProfesor(Profesor p);
     Profesor ProfesorbyId(Integer id);
}
