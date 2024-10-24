package com.example.proyectomarcos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "carnes")
public class Carne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "molida", updatable = false)
    private Boolean molida;

    @Column(name = "pollo", updatable = false)
    private Boolean pollo;

    @Column(name = "jamon", updatable = false)
    private Boolean jamon;

    @Column(name = "tocino", updatable = false)
    private Boolean tocino;

    @Column(name = "pepperoni", updatable = false)
    private Boolean pepperoni;

    @Column(name = "italiana", updatable = false)
    private Boolean italiana;
}
