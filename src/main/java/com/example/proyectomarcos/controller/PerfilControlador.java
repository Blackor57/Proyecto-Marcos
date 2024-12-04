package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.entity.Usuario;
import com.example.proyectomarcos.service.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PerfilControlador {

    private final UsuarioServicio usuarioServicio;

    @GetMapping("/perfil")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String verPerfil(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Usuario usuario = usuarioServicio.buscarPorEmail(email);
        model.addAttribute("usuario", usuario);
        return "Perfil";
    }

    @GetMapping("/admin/empleado")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String verEmpleado(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Usuario usuario = usuarioServicio.buscarPorEmail(email);
        model.addAttribute("usuario", usuario);
        return "empleado";
    }

    @GetMapping("/cooker/cocinero")
    @PreAuthorize("hasRole('ROLE_COOKER')")
    public String verCocinero(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Usuario usuario = usuarioServicio.buscarPorEmail(email);
        model.addAttribute("usuario", usuario);
        return "cocinero";
    }
}
