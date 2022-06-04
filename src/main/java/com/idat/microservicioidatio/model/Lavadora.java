package com.idat.microservicioidatio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "Lavadora")
@Entity
public class Lavadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLavadora;
    private String descripcion;
    private String marca;
    private String voltaje;

}
