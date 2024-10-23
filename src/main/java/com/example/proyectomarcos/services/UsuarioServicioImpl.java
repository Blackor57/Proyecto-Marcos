package com.example.proyectomarcos.services;

import com.example.proyectomarcos.dto.UsuarioRegistroDTO;
import com.example.proyectomarcos.entity.Rol;
import com.example.proyectomarcos.entity.Usuario;
import com.example.proyectomarcos.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Usuario save(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(),
                registroDTO.getEmail(), registroDTO.getBirthDate(), registroDTO.getPhone(),
                registroDTO.getPassword(), registroDTO.getDni(), Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepositorio.save(usuario);
    }


}
