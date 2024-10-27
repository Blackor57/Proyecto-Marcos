package com.example.proyectomarcos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Collection;

@Entity
@Data
@Table(name = "usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "dni")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "dni", length = 10, nullable = false)
    private String dni;

    @Column(name = "fec_nac")
    private String fecNac;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
    private Collection<Rol> roles;

    public Usuario(Long id, String nombre, String apellidos, String dni, String fecNac, String telefono, String email, String password, Collection<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fecNac = fecNac;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Usuario(String nombre, String apellidos, String dni, String fecNac, String telefono, String email, String password, Collection<Rol> roles) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fecNac = fecNac;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Usuario() {
    }
}
