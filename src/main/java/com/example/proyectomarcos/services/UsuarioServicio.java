package com.example.proyectomarcos.services;

import com.example.proyectomarcos.dto.UsuarioRegistroDTO;
import com.example.proyectomarcos.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioServicio extends UserDetailsService {
//    public Usuario save(UsuarioRegistroDTO registroDTO);

    public Usuario save(Usuario usuario);
}
