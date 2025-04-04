package com.libreria.demo.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import com.libreria.demo.entidades.Autor;
import com.libreria.demo.excepciones.MiException;
import com.libreria.demo.repositorios.AutorRepositorio;

@Service
public class AutorServicio {
    @Autowired
    private AutorRepositorio autorRepositorio;

    //Crear
    @Transactional
    public void crearAutor(String nombre) throws MiException {
        validar(nombre);
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autorRepositorio.save(autor); // Persisto el dato en mi BBDD
    }
    
    //Listar Autores
    public List<Autor> ListarAutores() {
        List<Autor> autores = new ArrayList<>();
        autores = autorRepositorio.findAll();
        return autores;
    }

    //Modificar Autores
     @Transactional
     public void modificarAutor(String nombre, UUID id){
     /*Optional<Autor> respuesta = autorRepositorio.findById(id);
     if (respuesta.isPresent()) {
     Autor autor = respuesta.get();*/
     Autor autor = new Autor();
     autor.setId(id);
     autor.setNombre(nombre);
     autorRepositorio.save(autor);
     }
     
     

    private void validar(String nombre) throws MiException {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
    }

}

