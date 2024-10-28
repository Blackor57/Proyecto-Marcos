package com.example.proyectomarcos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/order")
    public String order() {
        return "Ordenes";
    }

    @GetMapping("/reclamation")
    public String reclamation() {
        return "Reclamaciones";
    }

    @GetMapping("/rewards")
    public String rewards() {
        return "Reward";
    }

    @GetMapping("/personalizar")
    public String personalizar() {
        return "personaliza";
    }

    @GetMapping("/comprar")
    public String comprar() {
        return "carrito";
    }
}
