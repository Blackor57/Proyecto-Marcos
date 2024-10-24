package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrden extends JpaRepository<Orden, Integer> {
}
