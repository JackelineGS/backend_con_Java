package com.egg.biblioteca.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import jakarta.transaction.Transactional;

@Service
public class EditorialServicio {

    @Autowired
    EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) {
        Editorial editorial = new Editorial();

        editorial.setNombre(nombre);
        editorialRepositorio.save(editorial);
    }

    List<Editorial> listarEditoriales() {
        List<Editorial> editoriales = new ArrayList<>();
        editoriales = editorialRepositorio.findAll();
        return editoriales;
    }

    // Modificar Editorial
    @Transactional
    public void modificarEditorial(String nombre, UUID id) {
        /*
         * Optional<Autor> respuesta = autorRepositorio.findById(id);
         * if (respuesta.isPresent()) {
         * Autor autor = respuesta.get();
         */
        Editorial editorial = new Editorial();
        editorial.setId(id);
        editorial.setNombre(nombre);
        editorialRepositorio.save(editorial);
    }
}
