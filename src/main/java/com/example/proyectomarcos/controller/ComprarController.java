package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.entity.*;
import com.example.proyectomarcos.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"listaPizzas","listaAdi"})
@RequestMapping("/comprar")
public class ComprarController {

    private final Logger LOGGER= LoggerFactory.getLogger(PerzonalizaController.class);

    @Autowired
    private OrdenService ordenService;
    @Autowired
    private DetPizzaService detPizzaService;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private UsuarioServicioImpl usuarioServicio;
    @Autowired
    private AdicionalService adicionalService;
    @Autowired
    private DetAdicionalService detAdicionalService;
    
    @ModelAttribute("listaPizzas")
    public List<Pizza> listaPizzas() {
        return new ArrayList<Pizza>();
    }
    @ModelAttribute("listaAdi")
    public List<Adicional> listaAdi() {return new ArrayList<Adicional>();}
    
    
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
    public String borrarLista(@ModelAttribute("listaPizzas") List<Pizza> listaPizzas,
                              @ModelAttribute("listaAdi") List<Adicional> listaAdi) {
        listaPizzas.clear();
        listaAdi.clear();
        return "redirect:/comprar/previsual";
    }

    @PostMapping("/ordenar")
    public String ordenar(@ModelAttribute("listaPizzas") List<Pizza> listaPizzas,
                          @ModelAttribute("listaAdi") List<Adicional> listaAdi) {
        Orden orden = new Orden();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Usuario usuario = usuarioServicio.buscarPorEmail(email);
        if (usuario == null) {
            orden.setDni("12345678");
        } else {
        orden.setDni(usuario.getDni());
        }
        orden.setNombre("Prueba");
        orden.setEstado("Pendiente");
        orden.setMonto(100.00);
        orden.setMetodo("Tarjeta");

        ordenService.save(orden);

        for (Pizza p : listaPizzas) {

            DetPizza detPizza = new DetPizza();

            Integer idPizza;
            do {
                idPizza = detPizzaService.verificarPizza(p);
                if(idPizza == null) {
                    LOGGER.info("No existe pizza, procediendo a guardar");
                    pizzaService.savePizza(p);
                } else {
                    LOGGER.info("Este es el id de la pizza: {}", idPizza);
                }

            } while (idPizza == null);

            Pizza pizzaNueva = pizzaService.getPizzaById(idPizza).get();
            ordenService.agregarDetPizza(pizzaNueva, orden, 1, 20.00);

        }
        for (Adicional a : listaAdi) {

            DetAdicional detAdi = new DetAdicional();
            detAdi.setAdicional(a);
            detAdi.setOrden(orden);

            detAdicionalService.save(detAdi);

        }


        listaAdi.clear();
        listaPizzas.clear();
        return "/index";
    }

    @PostMapping("/agregarProducto/{id}")
    public void agregarProducto(@ModelAttribute("listaAdi") List<Adicional> listaAdicionales,
                                @PathVariable Integer id){
        Adicional adi = adicionalService.getAdicional(id).get();
        listaAdicionales.add(adi);
    }


}
