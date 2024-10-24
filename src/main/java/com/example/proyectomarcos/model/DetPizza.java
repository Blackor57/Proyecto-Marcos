package com.example.proyectomarcos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "det_pizza")
public class DetPizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "subtotal")
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "id_pizza")
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name = "id_orden")
    private Orden orden;

}
