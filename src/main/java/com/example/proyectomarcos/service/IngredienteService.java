package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.entity.Ingrediente;
import com.example.proyectomarcos.repository.IIngrendiente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

    @Autowired
    private IIngrendiente ingr;

    public List<Ingrediente> getIngredientes() {
        return ingr.findAll();
    }

    public Optional<Ingrediente> getIngrediente(Integer id) {
        return ingr.findById(id);
    }

    public void saveIngrediente(Ingrediente ingrediente) {
        ingr.save(ingrediente);
    }
    public void deleteIngredienteById(Integer id) {
        ingr.deleteById(id);
    }
}
