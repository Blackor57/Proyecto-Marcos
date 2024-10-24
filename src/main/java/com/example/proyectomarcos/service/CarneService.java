package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.Carne;
import com.example.proyectomarcos.repository.ICarne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarneService {

    @Autowired
    private ICarne ICarne;

    public List<Carne> getAllCarnes() {
        return ICarne.findAll();
    }

    public Optional<Carne> getCarne(Integer id) {
        return ICarne.findById(id);
    }

    public void setCarne(Carne carne) {
        ICarne.save(carne);
    }

    public void deleteCarneById(Integer id) {
        ICarne.deleteById(id);
    }
}
