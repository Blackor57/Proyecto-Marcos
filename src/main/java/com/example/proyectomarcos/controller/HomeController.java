package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.entity.DetAdicional;
import com.example.proyectomarcos.model.entity.DetPizza;
import com.example.proyectomarcos.repository.IDetAdicional;
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


    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/orders")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String orders(Model model) {

        List<DetPizza> pizzasPreparando = iDetPizza.findAllByEstadoPreparando();
        List<DetPizza> pizzasHorno = iDetPizza.findAllByEstadoEnHorno();
        List<DetPizza> pizzasTerminado = iDetPizza.findAllByEstadoTerminado();

        model.addAttribute("listaPreparando", pizzasPreparando);
        model.addAttribute("listaHorno", pizzasHorno);
        model.addAttribute("listaTerminado", pizzasTerminado);

        return "OrdersAdmin";
    }


    @GetMapping("/ventas")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String ventas(Model model) {

        LocalDate hoy = LocalDate.now();
        List<Orden> listaOrden = ordenService.getAllOrdenes();
        List<Orden> ordenesHoy = listaOrden.stream()
                .filter(orden -> orden.getHora() != null && orden.getHora().toLocalDate().equals(hoy))
                .collect(Collectors.toList());


        double total = 0.0;
        for (Orden o : ordenesHoy) {
            total += o.getMonto();
        }

        model.addAttribute("ordenes", ordenesHoy);
        model.addAttribute("total", total);

        return "ventas";
    }
}
