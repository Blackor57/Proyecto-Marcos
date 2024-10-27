package com.example.proyectomarcos.dto;

import lombok.Data;

@Data
public class UsuarioRegistroDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String fecNac;
    private String telefono;
    private String email;
    private String password;

    public UsuarioRegistroDTO(Long id, String nombre, String apellidos, String dni, String fecNac, String telefono, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fecNac = fecNac;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(String nombre, String apellidos, String dni, String fecNac, String telefono, String email, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fecNac = fecNac;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(String email) {
        this.email = email;
    }

    public UsuarioRegistroDTO() {
    }
}