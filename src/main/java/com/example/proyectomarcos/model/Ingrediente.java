package com.example.proyectomarcos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ingredientes")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cebolla", updatable = false)
    private Boolean cebolla;

    @Column(name = "champinon", updatable = false)
    private Boolean champinon;

    @Column(name = "aceituna", updatable = false)
    private Boolean aceituna;

    @Column(name = "pimiento", updatable = false)
    private Boolean pimiento;

    @Column(name = "pina", updatable = false)
    private Boolean pina;

    @Column(name = "cheddar", updatable = false)
    private Boolean cheddar;
}
