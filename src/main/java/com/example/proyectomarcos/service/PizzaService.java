package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.Pizza;
import com.example.proyectomarcos.repository.IPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    private IPizza IPizza;

    public List<Pizza> getAllPizzas() {
        return IPizza.findAll();
    }

    public Optional<Pizza> getPizzaById(Integer id) {
        return IPizza.findById(id);
    }

    public void savePizza(Pizza pizza) {
        IPizza.save(pizza);
    }

    public void deletePizzaById(Integer id) {
        IPizza.deleteById(id);
    }

}
