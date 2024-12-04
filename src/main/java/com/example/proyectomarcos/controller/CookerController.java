package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.entity.DetAdicional;
import com.example.proyectomarcos.model.entity.DetPizza;
import com.example.proyectomarcos.repository.IDetAdicional;
import com.example.proyectomarcos.repository.IDetPizza;
import com.example.proyectomarcos.service.DetPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cooker")
public class CookerController {

    @Autowired
    IDetPizza iDetPizza;
    @Autowired
    private DetPizzaService detPizzaService;
    @Autowired
    private IDetAdicional detAdicionalI;

    @GetMapping("/adminMoni")
    @PreAuthorize("hasRole('ROLE_COOK')")
    public String adminMoni(Model model) {
        List<DetPizza> terminados = iDetPizza.findAllByEstadoTerminado();
        List<DetPizza> enHorno = iDetPizza.findAllByEstadoEnHorno();
        List<DetPizza> preparando = iDetPizza.findAllByEstadoPreparando();

        model.addAttribute("terminadoList",terminados);
        model.addAttribute("hornoList",enHorno);
        model.addAttribute("preparandoList",preparando);

        return "monitoreo";
    }

    @GetMapping("/adminMoni/ver/{id}/{idOrden}")
    public String verPizza(Model model, @PathVariable Integer id, @PathVariable Integer idOrden) {
        DetPizza visualizar = iDetPizza.getById(id);  // Cargar la pizza por id
        List<DetPizza> terminados = iDetPizza.findAllByEstadoTerminado();
        List<DetPizza> enHorno = iDetPizza.findAllByEstadoEnHorno();
        List<DetPizza> preparando = iDetPizza.findAllByEstadoPreparando();
        List<DetAdicional> detAdicionales = detAdicionalI.findByOrdenId(idOrden);

        model.addAttribute("terminadoList", terminados);
        model.addAttribute("hornoList", enHorno);
        model.addAttribute("preparandoList", preparando);
        model.addAttribute("pizzaVisible", visualizar);  // Aquí es donde pasas la pizzaVisible al modelo
        model.addAttribute("detAdis", detAdicionales);

        return "monitoreo";  // Asegúrate de que este es el nombre correcto de tu vista
    }

    @PostMapping("/adminMoni/{estado}/{id}")
    public String cambiarEstado(Model model, @PathVariable Integer id, @PathVariable String estado) {
        DetPizza manejable = iDetPizza.getById(id);
        manejable.setEstado(estado);
        iDetPizza.save(manejable);

        return "redirect:/admin/adminMoni";
    }
}
