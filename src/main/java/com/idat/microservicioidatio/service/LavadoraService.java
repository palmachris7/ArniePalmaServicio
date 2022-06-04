package com.idat.microservicioidatio.service;

import com.idat.microservicioidatio.model.Lavadora;


import java.util.List;

public interface LavadoraService {
    List<Lavadora> listar();
    void guardarLavadora(Lavadora p);
   void eliminarLavadora(Integer id);
    void editarLavadora(Lavadora p);
     Lavadora LavadorabyId(Integer id);
}
