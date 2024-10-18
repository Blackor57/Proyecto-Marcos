package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.Usuario;
import com.example.proyectomarcos.repository.IUsuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private IUsuario IUsuario;

    public List<Usuario> findAll(){
        return IUsuario.findAll();
    }

    public Optional<Usuario> findById(Integer id){
        return IUsuario.findById(id);
    }

    public void saveUpdate(Usuario usuario){
        IUsuario.save(usuario);
    }

    public void deleteById(Integer id){
        IUsuario.deleteById(id);
    }


}
