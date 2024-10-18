package com.example.proyectomarcos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "dni", length = 10, nullable = false, unique = true)
    private String dni;

    @Column(name = "fec_nac")
    private Date fecNac;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
