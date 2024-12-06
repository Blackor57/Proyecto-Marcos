package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.entity.DetAdicional;
import com.example.proyectomarcos.model.entity.DetPizza;
import com.example.proyectomarcos.model.entity.Orden;
import com.example.proyectomarcos.repository.IDetAdicional;
import com.example.proyectomarcos.repository.IDetPizza;
import com.example.proyectomarcos.service.DetPizzaService;
import com.example.proyectomarcos.service.OrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    private OrdenService ordenService;
    @Autowired
    private DetPizzaService detPizzaService;
    @Autowired
    private IDetPizza iDetPizza;

    @GetMapping("/dashboard")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String dashboard(Model model) {

        LocalDate hoy = LocalDate.now();
        List<Orden> listaOrden = ordenService.getAllOrdenes();
        List<Orden> ordenesHoy = listaOrden.stream()
                .filter(orden -> orden.getHora() != null && orden.getHora().toLocalDate().equals(hoy))
                .collect(Collectors.toList());

        int ordenes = 0;
        double total = 0.0;
        int vendidas = 0;

        for (Orden o : ordenesHoy) {
            ordenes ++;
            total += o.getMonto();
            vendidas += detPizzaService.contarDetPizza(o.getId());
        }


        model.addAttribute("totalOrdenes", ordenes);
        model.addAttribute("totalVendidas", vendidas);
        model.addAttribute("totalDinero", total);

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
