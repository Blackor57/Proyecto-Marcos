package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.Adicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdicional extends JpaRepository<Adicional, Integer> {
}
