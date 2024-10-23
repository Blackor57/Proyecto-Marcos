package com.example.proyectomarcos.services;

import com.example.proyectomarcos.dto.UsuarioRegistroDTO;
import com.example.proyectomarcos.entity.Rol;
import com.example.proyectomarcos.entity.Usuario;
import com.example.proyectomarcos.repository.UsuarioRepositorio;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImpl(BCryptPasswordEncoder passwordEncoder, UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

//    @Override
//    public Usuario save(UsuarioRegistroDTO registroDTO) {
//        Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(),
//                registroDTO.getEmail(), registroDTO.getBirthDate(), registroDTO.getPhone(),
//                passwordEncoder.encode(registroDTO.getPassword()), registroDTO.getDni(), Arrays.asList(new Rol("ROLE_USER")));
//        return usuarioRepositorio.save(usuario);
//    }


    public Usuario save(Usuario registroDTO) {
        Usuario usuario = new Usuario(usuarioRepositorio.

                , Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepositorio.save(usuario);
    }

    UsuarioRepositorio.save

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("No se encontró el usuario");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
}
