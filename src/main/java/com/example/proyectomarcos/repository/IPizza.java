package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPizza extends JpaRepository<Pizza,Integer> {
}
