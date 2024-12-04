package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.entity.Adicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdicional extends JpaRepository<Adicional, Integer> {
    // Método con una consulta JPQL para buscar por categoría
    @Query("SELECT a FROM Adicional a WHERE a.categoria = :categoria")
    List<Adicional> findAdicionalesByCategoria(String categoria);
}
