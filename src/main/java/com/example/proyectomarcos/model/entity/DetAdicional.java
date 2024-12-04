package com.example.proyectomarcos.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "det_adi")
public class DetAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_adicional", nullable = false)
    private Adicional adicional;

    @ManyToOne
    @JoinColumn(name = "id_orden", nullable = false)
    private Orden orden;
}
