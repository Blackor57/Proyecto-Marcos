package com.example.proyectomarcos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRegistroDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String fecNac;
    private String telefono;
    private String email;
    private String password;
    
}