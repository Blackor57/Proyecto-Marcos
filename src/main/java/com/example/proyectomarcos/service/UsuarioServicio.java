package com.example.proyectomarcos.service;

import com.example.proyectomarcos.dto.UsuarioRegistroDTO;
import com.example.proyectomarcos.model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioServicio extends UserDetailsService {

    public Usuario save(UsuarioRegistroDTO registroDTO);

    Usuario buscarPorEmail(String email);
}
