package com.egg.biblioteca.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.repositorios.LibroRepositorio;
import jakarta.transaction.Transactional;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;
    @Autowired
    private AutorRepositorio autorRepositorio;
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    public void crearLibro(Long isbn, String titulo, Integer Ejemplares, String editorialId, String autorId) throws MiException {

        Autor autor = autorRepositorio.findById(autorId).get();
        Editorial editorial = editorialRepositorio.findById(editorialId).get();
        validar(titulo);
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(Ejemplares);
        libro.setAlta(new Date()); // El atributo Alta, será directamente seteado con un objeto del tipo DATE, que
                                   // esto permitirá almacenar la fecha del momento en que se está creando el
                                   // objeto.
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libroRepositorio.save(libro);
    }

    private void validar(String nombre) throws MiException {
        if(nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre no puede ser nulo o estar vacio");
        }
    }

    @Transactional()
    public List<Libro> listarLibros() {
        List<Libro> libros = new ArrayList<>();
        libros = libroRepositorio.findAll();
        return libros;
    }

    // Modificar Libro
    @Transactional
    public void modificarLibro(Long isbn, String titulo, Integer Ejemplares, String editorialId, String autorId) {
        
        Autor autor = autorRepositorio.findById(autorId).get();
        Editorial editorial = editorialRepositorio.findById(editorialId).get();
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(Ejemplares);
        libro.setEditorial(editorial);
        libro.setAutor(autor);
        libroRepositorio.save(libro);
    }

}
