package com.egg.biblioteca.entidades;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.egg.biblioteca.enumeraciones.Rol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue (generator = "uuid")
    @Column(name = "id_usuario") 
    private UUID idUsuario;

    private String id;
    private String nombre;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;


    public Usuario() {
    }

    public Usuario(UUID idUsuario, String id, String nombre, String email, String password, Rol rol) {
        this.idUsuario = idUsuario;
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public UUID getAutorId() {
        return idUsuario;
    }
    public void setAutorId(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    
}
