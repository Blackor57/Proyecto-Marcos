package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngrendiente extends JpaRepository<Ingrediente, Integer> {

}
