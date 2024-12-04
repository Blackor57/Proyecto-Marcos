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


}
