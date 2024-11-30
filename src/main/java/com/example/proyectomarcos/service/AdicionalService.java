package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.entity.Adicional;
import com.example.proyectomarcos.repository.IAdicional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdicionalService {

    @Autowired
    private IAdicional IAdicional;

    public List<Adicional> getAllAdicional(){
        return IAdicional.findAll();
    }

    public Optional<Adicional> getAdicional(Integer id){
        return IAdicional.findById(id);
    }

    public void saveAdicional(Adicional adicional){
        IAdicional.save(adicional);
    }

    public void deleteAdicionalById(Integer id){
        IAdicional.deleteById(id);
    }

}
