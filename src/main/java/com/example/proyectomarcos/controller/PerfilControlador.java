package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.Usuario;
import com.example.proyectomarcos.service.UsuarioServicio;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerfilControlador {

    private final UsuarioServicio usuarioServicio;

    public PerfilControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/perfil")
    public String verPerfil(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Usuario usuario = usuarioServicio.buscarPorEmail(email);
        model.addAttribute("usuario", usuario);
        return "Perfil";
    }
}
