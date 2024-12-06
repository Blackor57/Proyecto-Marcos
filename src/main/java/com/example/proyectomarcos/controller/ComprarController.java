package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.entity.*;
import com.example.proyectomarcos.repository.IAdicional;
import com.example.proyectomarcos.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
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
    @Autowired
    private IAdicional adiRepo;
    
    @ModelAttribute("listaPizzas")
    public List<Pizza> listaPizzas() {
        return new ArrayList<Pizza>();
    }
    @ModelAttribute("listaAdi")
    public List<Adicional> listaAdi() {return new ArrayList<Adicional>();}
    
    
    @GetMapping("")
    public String comprar(Model model) {

        List<Adicional> listBebida = adiRepo.findAdicionalesByCategoria("bebida");
        List<Adicional> listVino = adiRepo.findAdicionalesByCategoria("vino");
        List<Adicional> listCoctel = adiRepo.findAdicionalesByCategoria("coctel");
        List<Adicional> listPostre = adiRepo.findAdicionalesByCategoria("postre");
        List<Adicional> listUtensilio = adiRepo.findAdicionalesByCategoria("utensilio");

        model.addAttribute("listBebida", listBebida);
        model.addAttribute("listVino", listVino);
        model.addAttribute("listCoctel", listCoctel);
        model.addAttribute("listPostre", listPostre);
        model.addAttribute("listUtensilio", listUtensilio);

        return "carrito";
    }

    @GetMapping("/previsual")
    public String previsual(Model model,
                            @ModelAttribute("listaPizzas") List<Pizza> listaPizzas,
                            @ModelAttribute("listaAdi") List<Adicional> listaAdi) {

        Double precio = 0.0;
        for (Pizza p : listaPizzas) {
           precio += 20.00;
        }
        for (Adicional a : listaAdi) {
            precio += a.getPrecio();
        }
        model.addAttribute("listaPizzas", listaPizzas);
        model.addAttribute("listaAdi", listaAdi);
        model.addAttribute("precio", precio);
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
            orden.setNombre("Anonimo");
        } else {
            orden.setDni(usuario.getDni());
            orden.setNombre(usuario.getNombre());
        }
        orden.setEstado("Pendiente");
        orden.setMetodo("Tarjeta");
        orden.setHora(LocalDateTime.now());
        ordenService.save(orden);
        Double montoTotal = 0.0;
        for (Pizza p : listaPizzas) {

            DetPizza detPizza = new DetPizza();
            montoTotal += 20;
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
            montoTotal += a.getPrecio();
            DetAdicional detAdi = new DetAdicional();
            detAdi.setAdicional(a);
            detAdi.setOrden(orden);

            detAdicionalService.save(detAdi);

        }

        if (usuario != null) {
            LOGGER.info("Monto total: {}",montoTotal);
            int estrellas = montoTotal.intValue() / 4;
            LOGGER.info("Estrellas: {}",estrellas);
            usuario.setStar(usuario.getStar() + estrellas);
        }

        orden.setMonto(montoTotal);
        ordenService.save(orden);
        listaAdi.clear();
        listaPizzas.clear();

        return "redirect:/public/factura?idOrden=" + orden.getId();
    }

    @PostMapping("/agregarProducto/{id}")
    public String agregarProducto(@ModelAttribute("listaAdi") List<Adicional> listaAdicionales,
                                  @ModelAttribute("listaPizzas") List<Pizza> listaPizzas,
                                  @PathVariable Integer id,
                                  Model model){
        Adicional adi = adicionalService.getAdicional(id).get();
        listaAdicionales.add(adi);

        model.addAttribute("listaPizzas", listaPizzas);
        model.addAttribute("listaAdi", listaAdicionales);
        return "redirect:/comprar/previsual";
    }

    @PostMapping("/agregarPizza/{id}")
    public String agregarPizza(@ModelAttribute("listaAdi") List<Adicional> listaAdicionales,
                                  @ModelAttribute("listaPizzas") List<Pizza> listaPizzas,
                                  @PathVariable Integer id,
                                  Model model){
        Pizza pizza = pizzaService.getPizzaById(id).get();
        listaPizzas.add(pizza);

        model.addAttribute("listaPizzas", listaPizzas);
        model.addAttribute("listaAdi", listaAdicionales);
        return "redirect:/comprar/previsual";
    }

}
