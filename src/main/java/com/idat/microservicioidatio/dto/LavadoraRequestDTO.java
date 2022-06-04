package com.idat.microservicioidatio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LavadoraRequestDTO {
    private Integer idRequest;
    private String descripcion;
    private String marca;
    private String voltaje;

}