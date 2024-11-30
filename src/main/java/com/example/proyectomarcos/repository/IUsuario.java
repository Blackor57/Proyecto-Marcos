package com.example.proyectomarcos.repository;

import com.example.proyectomarcos.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario extends JpaRepository<Usuario, Integer> {

    public Usuario findByEmail(String email);


}
