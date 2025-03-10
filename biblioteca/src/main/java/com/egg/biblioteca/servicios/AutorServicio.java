package com.egg.biblioteca.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.repositorios.AutorRepositorio;

@Service
public class AutorServicio {
    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre){

        Autor autor = new Autor();
        autor.setNombre(nombre);
        
        autorRepositorio.save(autor);
    }

    public List<Autor> ListarAutores(){
        List<Autor> autores = new ArrayList<>();
        autores = autorRepositorio.findAll();
        return autores;
    }

    /*@Transactional
    public void modificarAutor(String nombre, String id){     
        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
           
            autor.setNombre(nombre);
            autorRepositorio.save(autor);
        }
    }*/


}
