package com.example.proyectomarcos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ordenes")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @Column(name = "monto", nullable = false)
    private double monto;

    @Column(name = "metodo_pago", nullable = false, length = 20)
    private String metodo;

    @Column(name = "dni")
    private String dni;
}
