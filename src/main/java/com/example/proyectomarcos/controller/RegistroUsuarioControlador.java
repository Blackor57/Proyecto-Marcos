package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.dto.UsuarioRegistroDTO;
import com.example.proyectomarcos.service.UsuarioServicio;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO, Model model) {
        try {
            usuarioServicio.save(registroDTO);
            return "redirect:/registro?good";
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("dni")) {
                model.addAttribute("dniError", true);
            } else if (e.getMessage().contains("email")) {
                model.addAttribute("emailError", true);
            }
            model.addAttribute("usuario", registroDTO);
            return "registro";
        }
    }
}
