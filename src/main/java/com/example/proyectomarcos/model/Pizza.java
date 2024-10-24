package com.example.proyectomarcos.model;

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

    @Column(name = "queso_cantidad", nullable = false, length = 20)
    private String quesoCant;

    @Column(name = "salsa", nullable = false, length = 20)
    private String salsa;

    @ManyToOne
    @JoinColumn(name = "id_carnes")
    private Carne carne;

    @ManyToOne
    @JoinColumn(name = "id_ingredientes")
    private Ingrediente ingrediente;

}
