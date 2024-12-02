package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.entity.DetPizza;
import com.example.proyectomarcos.model.entity.Ingrediente;
import com.example.proyectomarcos.model.entity.Orden;
import com.example.proyectomarcos.model.entity.Pizza;
import com.example.proyectomarcos.repository.IDetPizza;
import com.example.proyectomarcos.repository.IOrden;
import com.example.proyectomarcos.repository.IPizza;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private IOrden IOrden;
    @Autowired
    private IDetPizza IDetPizza;

    public List<Orden> getAllOrdenes() {
        return IOrden.findAll();
    }

    public Optional<Orden> getOrdenById(Integer id) {
        return IOrden.findById(id);
    }

    public void save(Orden orden) {
        IOrden.save(orden);
    }

    public void deleteById(Integer id) {
        IOrden.deleteById(id);
    }


    public void agregarDetPizza(Pizza pizza, Orden orden, int cantidad, double subtotal){
        DetPizza detPizza = new DetPizza();
        detPizza.setPizza(pizza);
        detPizza.setSubtotal(subtotal);
        detPizza.setCantidad(cantidad);
        detPizza.setOrden(orden);
        detPizza.setEstado("Preparando");
        IDetPizza.save(detPizza);
    }

}
