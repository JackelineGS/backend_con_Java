package com.libreria.demo.entidades;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @Column(name = "isbn")  
    private Long isbn;  

    @Column(name = "titulo")
    private String titulo;
    
    @Column(name = "ejemplares")
    private Integer ejemplares;

    @Temporal(TemporalType.DATE)
    private Date alta;
    
    @ManyToOne()
    @JoinColumn(name = "autor_id")
    private Autor autor;
    
    @ManyToOne()
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    public Libro() {
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }


}
