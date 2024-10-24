package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.Carne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarne extends JpaRepository<Carne, Integer> {

}
