package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.entity.Adicional;
import com.example.proyectomarcos.model.entity.DetAdicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetAdicional extends JpaRepository<DetAdicional, Integer> {
    @Query("SELECT d FROM DetAdicional d WHERE d.orden.id = :idOrden")
    List<DetAdicional> findByOrdenId(@Param("idOrden") Integer idOrden);
}
