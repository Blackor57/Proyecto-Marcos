package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.Usuario;
import com.example.proyectomarcos.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @GetMapping("")
    public String login() {
        return "login";
    }

    @PostMapping("/save")
    public String save(Usuario usuario){
        logger.info("Usuario Registrado: {}", usuario);
        return "redirect:/login";
    }

}
