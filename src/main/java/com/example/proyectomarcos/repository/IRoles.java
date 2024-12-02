package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoles extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);


}
