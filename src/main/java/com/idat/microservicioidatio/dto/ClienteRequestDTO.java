package com.idat.microservicioidatio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequestDTO {
    private Integer idRequest;
    private String nombreCliente;
    private String apellidoCliente;
    private String nrocelular;
    private String direccion;

}
