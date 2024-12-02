package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.entity.DetPizza;
import com.example.proyectomarcos.repository.IDetPizza;
import com.example.proyectomarcos.service.DetPizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    IDetPizza iDetPizza;
    @Autowired
    private DetPizzaService detPizzaService;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/adminMoni")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminMoni(Model model) {
        List<DetPizza> terminados = iDetPizza.findAllByEstadoTerminado();
        List<DetPizza> enHorno = iDetPizza.findAllByEstadoEnHorno();
        List<DetPizza> preparando = iDetPizza.findAllByEstadoPreparando();

        model.addAttribute("terminadoList",terminados);
        model.addAttribute("hornoList",enHorno);
        model.addAttribute("preparandoList",preparando);

        return "monitoreo";
    }

    @GetMapping("/adminMoni/ver/{id}")
    public String verPizza(Model model, @PathVariable Integer id) {
        DetPizza visualizar = iDetPizza.getById(id);
        List<DetPizza> terminados = iDetPizza.findAllByEstadoTerminado();
        List<DetPizza> enHorno = iDetPizza.findAllByEstadoEnHorno();
        List<DetPizza> preparando = iDetPizza.findAllByEstadoPreparando();

        model.addAttribute("terminadoList",terminados);
        model.addAttribute("hornoList",enHorno);
        model.addAttribute("preparandoList",preparando);
        model.addAttribute("pizzaVisible", visualizar);

        return "monitoreo";
    }

    @PostMapping("/adminMoni/{estado}/{id}")
    public String cambiarEstado(Model model, @PathVariable Integer id, @PathVariable String estado) {
        DetPizza manejable = iDetPizza.getById(id);
        manejable.setEstado(estado);
        iDetPizza.save(manejable);

        return "redirect:/admin/adminMoni";
    }

}
