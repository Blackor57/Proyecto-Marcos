package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.Carne;
import com.example.proyectomarcos.model.Ingrediente;
import com.example.proyectomarcos.model.Pizza;
import com.example.proyectomarcos.service.CarneService;
import com.example.proyectomarcos.service.IngredienteService;
import com.example.proyectomarcos.service.PizzaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personaliza")
public class PerzonalizaController {

    private final Logger LOGGER= LoggerFactory.getLogger(PerzonalizaController.class);

    @Autowired
    private CarneService carneService;
    @Autowired
    private IngredienteService ingredienteService;
    @Autowired
    private PizzaService pizzaService;

    @GetMapping("")
    public String personalize(Model model) {
        model.addAttribute("pizza", new Pizza()); // O el objeto que corresponda
        model.addAttribute("carnes", new Carne()); // O el objeto que corresponda
        model.addAttribute("ingredientes", new Ingrediente()); // O el objeto que corresponda
        return "personalizar";
    }

    @PostMapping("/agregarPersonalizada")
    public String agregarPizza(@ModelAttribute("pizza") Pizza pizza,
                               @ModelAttribute("carnes") Carne carne,
                               @ModelAttribute("ingredientes") Ingrediente ingrediente,
                               Model model) {

        LOGGER.info("Este es el obj pizza{}", pizza);
        LOGGER.info("Este es el obj carne{}", carne);
        LOGGER.info("Este es el obj ingrediente{}", ingrediente);

        return "redirect:/order";
    }


}
