package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.DetPizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetPizza extends JpaRepository<DetPizza,Integer> {
}
