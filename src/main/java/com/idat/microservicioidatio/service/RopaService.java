package com.idat.microservicioidatio.service;


import com.idat.microservicioidatio.model.Ropa;

import java.util.List;

public interface RopaService {
    List<Ropa> listar();
    void guardarRopa(Ropa p);
    void eliminarRopa(Integer id);
    void editarRopa(Ropa e);
    Ropa RopabyId(Integer id);
}
