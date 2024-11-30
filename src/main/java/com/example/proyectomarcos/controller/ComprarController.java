package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.entity.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("listaPizzas")
@RequestMapping("/comprar")
public class ComprarController {


    @ModelAttribute("listaPizzas")
    public List<Pizza> listaPizzas() {
        return new ArrayList<Pizza>();
    }

    @GetMapping("")
    public String comprar() {
        return "carrito";
    }

    @GetMapping("/previsual")
    public String previsual(Model model,
                            @ModelAttribute("listaPizzas") List<Pizza> listaPizzas) {
        model.addAttribute("listaPizzas", listaPizzas);
        return "previsual";
    }

    @PostMapping("/borrarLista")
    public String borrarLista(@ModelAttribute("listaPizzas") List<Pizza> listaPizzas) {
        listaPizzas.clear();
        return "redirect:/comprar/previsual";
    }
}
