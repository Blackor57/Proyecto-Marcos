package com.example.proyectomarcos.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@Table(name = "ingredientes")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cebolla", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String cebolla;

    @Column(name = "champinon", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String champinon;

    @Column(name = "aceituna", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String aceituna;

    @Column(name = "pimiento", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String pimiento;

    @Column(name = "pina", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String pina;

    @Column(name = "cheddar", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String cheddar;
}
