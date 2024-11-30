package com.example.proyectomarcos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pizzas")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tamano", nullable = false, length = 20)
    private String tamano;

    @Column(name = "masa", nullable = false, length = 20)
    private String masa;

    @Column(name = "queso_cantidad", nullable = false, length = 20)
    private String queso;

    @Column(name = "salsa", nullable = false, length = 20)
    private String salsa;

    @ManyToOne
    @JoinColumn(name = "id_carnes")
    private Carne carne;

    @ManyToOne
    @JoinColumn(name = "id_ingredientes")
    private Ingrediente ingrediente;

}
