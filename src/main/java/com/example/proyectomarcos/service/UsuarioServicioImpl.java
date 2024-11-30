package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.dto.UsuarioRegistroDTO;
import com.example.proyectomarcos.model.entity.Rol;
import com.example.proyectomarcos.model.entity.Usuario;
import com.example.proyectomarcos.repository.IUsuario;
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
    private final IUsuario usuarioRepositorio;

    public UsuarioServicioImpl(BCryptPasswordEncoder passwordEncoder, IUsuario usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Usuario save(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = Usuario.builder()
                .nombre(registroDTO.getNombre())
                .apellidos(registroDTO.getApellidos())
                .dni(registroDTO.getDni())
                .fecNac(registroDTO.getFecNac())
                .telefono(registroDTO.getTelefono())
                .email(registroDTO.getEmail())
                .password(passwordEncoder.encode(registroDTO.getPassword()))
                .roles(Arrays.asList(new Rol("ROLE_USER")))
                .build();
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }

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
