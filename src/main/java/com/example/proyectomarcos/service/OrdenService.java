package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.Orden;
import com.example.proyectomarcos.repository.IOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private IOrden IOrden;

    public List<Orden> getAllOrdenes(){
        return IOrden.findAll();
    }

    public Optional<Orden> getOrdenById(Integer id){
        return IOrden.findById(id);
    }

    public void save(Orden orden){
        IOrden.save(orden);
    }

    public void deleteById(Integer id){
        IOrden.deleteById(id);
    }

}
