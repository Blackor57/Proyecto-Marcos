package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.dto.UsuarioRegistroDTO;
import com.example.proyectomarcos.model.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioServicio extends UserDetailsService {

    public Usuario save(UsuarioRegistroDTO registroDTO);

    Usuario saveAdmin(UsuarioRegistroDTO registroDTO);

    Usuario buscarPorEmail(String email);
}
