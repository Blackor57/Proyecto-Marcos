package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.entity.DetAdicional;
import com.example.proyectomarcos.model.entity.DetPizza;
import com.example.proyectomarcos.model.entity.Orden;
import com.example.proyectomarcos.model.entity.Usuario;
import com.example.proyectomarcos.repository.IDetAdicional;
import com.example.proyectomarcos.repository.IDetPizza;
import com.example.proyectomarcos.repository.IOrden;
import com.example.proyectomarcos.service.OrdenService;
import com.example.proyectomarcos.service.UsuarioServicioImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {

    @Autowired
    private OrdenService ordenService;
    @Autowired
    IDetPizza iDetPizza;
    @Autowired
    UsuarioServicioImpl usuarioServicio;
    @Autowired
    private IDetAdicional detAdicionalI;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("order")
    public String order(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Usuario usuario = usuarioServicio.buscarPorEmail(email);
        List<DetPizza> terminados = iDetPizza.findAllByEstadoTerminadoAndDni(usuario.getDni());
        List<DetPizza> enHorno = iDetPizza.findAllByEstadoEnHornoAndDni(usuario.getDni());
        List<DetPizza> preparando = iDetPizza.findAllByEstadoPreparandoAndDni(usuario.getDni());

        model.addAttribute("terminadoList",terminados);
        model.addAttribute("hornoList",enHorno);
        model.addAttribute("preparandoList",preparando);

        return "Ordenes";
    }

    @GetMapping("reclamation")
    public String reclamation() {
        return "Reclamaciones";
    }

    @GetMapping("rewards")
    public String rewards() {
        return "Reward";
    }

    @GetMapping("factura")
    public String factura(@RequestParam("idOrden") Integer idOrden, Model model) {
        // Obtener la orden específica
        Optional<Orden> ordenOptional = ordenService.getOrdenById(idOrden);
        if (ordenOptional.isEmpty()) {
            // Manejo de error si la orden no existe
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden no encontrada");
        }
        Orden orden = ordenOptional.get();

        // Obtener las pizzas y adicionales asociados a esa orden
        List<DetPizza> detPizzas = iDetPizza.findAllByOrdenId(idOrden);
        List<DetAdicional> detAdicionales = detAdicionalI.findByOrdenId(idOrden);

        // Agregar datos al modelo
        model.addAttribute("orden", orden);
        model.addAttribute("detPizzas", detPizzas);
        model.addAttribute("detAdicionales", detAdicionales);

        return "factura";
    }
}