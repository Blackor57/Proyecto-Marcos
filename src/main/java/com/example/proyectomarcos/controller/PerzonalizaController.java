package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.entity.Carne;
import com.example.proyectomarcos.model.entity.Ingrediente;
import com.example.proyectomarcos.model.entity.Pizza;
import com.example.proyectomarcos.service.CarneService;
import com.example.proyectomarcos.service.IngredienteService;
import com.example.proyectomarcos.service.PizzaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("listaPizzas")
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
        model.addAttribute("ingredientes", new Ingrediente());// O el objeto que corresponda
        return "personaliza";
    }

    @PostMapping("/agregarPersonalizada")
    public String agregarPizza(@ModelAttribute("pizza") Pizza pizza,
                               @ModelAttribute("carnes") Carne carne,
                               @ModelAttribute("ingredientes") Ingrediente ingrediente,
                               @ModelAttribute("listaPizzas") List<Pizza> listaPizzas,
                               Model model) {

        LOGGER.info("Este es el obj pizza{}", pizza);
        LOGGER.info("Este es el obj carne{}", carne);
        LOGGER.info("Este es el obj ingrediente{}", ingrediente);

        Integer idIngre;
        do {
            idIngre = pizzaService.VerificarIngredientes(ingrediente);
            if (idIngre == null) {
                LOGGER.info("No existe ingrediente, procediendo a guardar");
                ingredienteService.saveIngrediente(ingrediente);
            } else {
                LOGGER.info("Este es el id del ingrediente{}", idIngre);

            }
        } while (idIngre == null);

        Ingrediente ingredienteNuevo = ingredienteService.getIngrediente(idIngre).get();
        pizza.setIngrediente(ingredienteNuevo);

        Integer idCarne;
        do {
            idCarne = pizzaService.VerificarCarnes(carne);
            if (idCarne == null) {
                LOGGER.info("No existe carnes, procediendo a guardar");
                carneService.saveCarne(carne);
            } else {
                LOGGER.info("Este es el id de la carne{}", idCarne);

            }
        } while (idCarne == null);

        Carne carneNueva = carneService.getCarne(idCarne).get();
        pizza.setCarne(carneNueva);

        listaPizzas.add(pizza);

        return "redirect:/comprar/previsual";
    }





}
