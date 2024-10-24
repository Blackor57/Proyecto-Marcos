package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.services.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    @Autowired
    private UsuarioServicio servicio;

    @GetMapping("/")
    public String home() {
        return "index";
    }

//
//    @GetMapping("/about")
//    public String about() {
//        return "categorias";
//    }
//
//    @GetMapping("/order")
//    public String order() {
//        return "Ordenes";
//    }
//
//    @GetMapping("/Perzone")
//    public String Perzone() {
//        return "Perzonaliza";
//    }
//
//    @GetMapping("/reclamation")
//    public String reclamation() {
//        return "Reclamaciones";
//    }
//
//    @GetMapping("/rewards")
//    public String rewards() {
//        return "Reward";
//    }
//
//    @GetMapping("/perfil")
//    public String perfil() {
//        return "Perfil";
//    }
//
//    @GetMapping("/comprar")
//    public String comprar() {
//        return "carrito";
//    }
}
