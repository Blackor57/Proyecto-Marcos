package com.example.proyectomarcos.controller;

import com.example.proyectomarcos.model.entity.DetPizza;
import com.example.proyectomarcos.model.entity.Usuario;
import com.example.proyectomarcos.repository.IDetPizza;
import com.example.proyectomarcos.service.UsuarioServicioImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {


    @Autowired
    IDetPizza iDetPizza;
    @Autowired
    UsuarioServicioImpl usuarioServicio;

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

}