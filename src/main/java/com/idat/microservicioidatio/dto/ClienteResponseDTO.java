package com.idat.microservicioidatio.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClienteResponseDTO {

        private Integer idResponse;
        private String nombreCliente;
        private String apellidoCliente;
        private String nrocelular;
        private String direccion;
}
