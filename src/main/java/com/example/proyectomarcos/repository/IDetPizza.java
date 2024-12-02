package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.entity.DetPizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetPizza extends JpaRepository<DetPizza,Integer> {

    // Obtener todas las DetPizza por estado "Preparando"
    @Query("SELECT d FROM DetPizza d WHERE d.estado = 'Preparando'")
    List<DetPizza> findAllByEstadoPreparando();

    // Obtener todas las DetPizza por estado "En horno"
    @Query("SELECT d FROM DetPizza d WHERE d.estado = 'EnHorno'")
    List<DetPizza> findAllByEstadoEnHorno();

    // Obtener todas las DetPizza por estado "Terminado"
    @Query("SELECT d FROM DetPizza d WHERE d.estado = 'Terminado'")
    List<DetPizza> findAllByEstadoTerminado();

    // Obtener todas las DetPizza por estado "Preparando" y filtrar por DNI
    @Query("SELECT d FROM DetPizza d WHERE d.estado = 'Preparando' AND d.orden.dni = :dni")
    List<DetPizza> findAllByEstadoPreparandoAndDni(@Param("dni") String dni);

    // Obtener todas las DetPizza por estado "En horno" y filtrar por DNI
    @Query("SELECT d FROM DetPizza d WHERE d.estado = 'EnHorno' AND d.orden.dni = :dni")
    List<DetPizza> findAllByEstadoEnHornoAndDni(@Param("dni") String dni);

    // Obtener todas las DetPizza por estado "Terminado" y filtrar por DNI
    @Query("SELECT d FROM DetPizza d WHERE d.estado = 'Terminado' AND d.orden.dni = :dni")
    List<DetPizza> findAllByEstadoTerminadoAndDni(@Param("dni") String dni);
}
