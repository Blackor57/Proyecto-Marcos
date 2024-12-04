package com.example.proyectomarcos.service;

import com.example.proyectomarcos.model.dto.UsuarioRegistroDTO;
import com.example.proyectomarcos.model.entity.Rol;
import com.example.proyectomarcos.model.entity.Usuario;
import com.example.proyectomarcos.repository.IRoles;
import com.example.proyectomarcos.repository.IUsuario;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
public class UsuarioServicioImpl implements UsuarioServicio {

    private final BCryptPasswordEncoder passwordEncoder;
    private final IUsuario usuarioRepositorio;
    private final IRoles rolRepositorio;

    @Override
    public Usuario save(UsuarioRegistroDTO registroDTO) {
        // Buscar el rol "ROLE_USER" en la base de datos
        Rol rolUsuario = rolRepositorio.findByNombre("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("El rol 'ROLE_USER' no existe en la base de datos"));

        // Crear el usuario y asignarle el rol encontrado
        Usuario usuario = Usuario.builder()
                .nombre(registroDTO.getNombre())
                .apellidos(registroDTO.getApellidos())
                .dni(registroDTO.getDni())
                .fecNac(registroDTO.getFecNac())
                .telefono(registroDTO.getTelefono())
                .email(registroDTO.getEmail())
                .password(passwordEncoder.encode(registroDTO.getPassword()))
                .roles(Arrays.asList(rolUsuario))
                .build();

        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario saveAdmin(UsuarioRegistroDTO registroDTO) {
        Rol rolAdmin = rolRepositorio.findByNombre("ROLE_ADMIN")
                .orElseThrow(() -> new RuntimeException("El rol 'ROLE_ADMIN' no existe en la base de datos"));

        Usuario admin = Usuario.builder()
                .nombre(registroDTO.getNombre())
                .apellidos(registroDTO.getApellidos())
                .dni(registroDTO.getDni())
                .fecNac(registroDTO.getFecNac())
                .telefono(registroDTO.getTelefono())
                .email(registroDTO.getEmail())
                .password(passwordEncoder.encode(registroDTO.getPassword()))
                .roles(Arrays.asList(rolAdmin))
                .build();
        return usuarioRepositorio.save(admin);
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
