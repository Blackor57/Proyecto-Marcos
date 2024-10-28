package com.example.proyectomarcos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class InformacionController {

    @GetMapping("")
    public String about() {
        return "categorias";
    }

    @GetMapping("/pizzas")
    public String pizzas() {
        return "cat-pizzas";
    }

    @GetMapping("/bebidas")
    public String bebidas() {
        return "cat-bebidas";
    }

    @GetMapping("/postres")
    public String postres() {
        return "cat-postres";
    }

    @GetMapping("/utensilios")
    public String utensilios() {
        return "cat-utensilios";
    }

}
