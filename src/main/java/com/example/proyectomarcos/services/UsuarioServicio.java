package com.example.proyectomarcos.services;

import com.example.proyectomarcos.dto.UsuarioRegistroDTO;
import com.example.proyectomarcos.entity.Usuario;

public interface UsuarioServicio {
    public Usuario save(UsuarioRegistroDTO registroDTO);
}
