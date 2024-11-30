package com.example.proyectomarcos.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@Table(name = "carnes")
public class Carne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "molida", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String molida;

    @Column(name = "pollo", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String pollo;

    @Column(name = "jamon", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String jamon;

    @Column(name = "tocino", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String tocino;

    @Column(name = "pepperoni", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String pepperoni;

    @Column(name = "italiana", updatable = false, length = 1, nullable = false)
    @ColumnDefault("0")
    private String italiana;
}
