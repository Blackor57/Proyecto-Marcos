package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.DetAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetAdicional extends JpaRepository<DetAdicional, Integer> {
}
