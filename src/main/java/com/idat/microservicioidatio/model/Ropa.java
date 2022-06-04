package com.idat.microservicioidatio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "Ropa")
@Entity
public class Ropa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRopa;
    private String tipoRopa;
    private String descripcion;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="cliente_ropa",
            joinColumns =  @JoinColumn(name="id_cliente", nullable = false, unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references Cliente (id_cliente)")),
            inverseJoinColumns = @JoinColumn(name="id_ropa", nullable = false, unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_ropa) references Ropa (id_ropa)"))

    )
    private List<Cliente> clientes = new ArrayList<>();
}
