package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.DetPizza;
import com.example.proyectomarcos.repository.IDetPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetPizzaService {

    @Autowired
    private IDetPizza IDetPizza;

    public List<DetPizza> getAllDetPizza() {
        return IDetPizza.findAll();
    }

    public Optional<DetPizza> getDetPizzaById(Integer id) {
        return IDetPizza.findById(id);
    }

    public void save(DetPizza detPizza) {
        IDetPizza.save(detPizza);
    }

    public void deleteById(Integer id) {
        IDetPizza.deleteById(id);
    }

}
