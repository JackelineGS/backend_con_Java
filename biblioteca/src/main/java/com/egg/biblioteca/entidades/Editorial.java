package com.egg.biblioteca.entidades;

import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "editorial")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "editorial_id")
    private UUID editorialId;


    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;

    public Editorial() {
    }

    public UUID getId() {
        return editorialId;
    }

    public void setId(UUID editorialId) {
        this.editorialId = editorialId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    
}
