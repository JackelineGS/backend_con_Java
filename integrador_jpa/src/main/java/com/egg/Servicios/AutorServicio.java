package com.egg.Servicios;

import java.util.List;
import com.egg.Entidades.Autor;
import com.egg.Persistencia.AutorDAO;

public class AutorServicio {

    private final AutorDAO autorDAO;

    public AutorServicio() {
        this.autorDAO = new AutorDAO();
    }

    public void guardarAutor(String nombre, Boolean alta) {
        try {
            Autor autorNuevo = new Autor();
            autorNuevo.setNombre(nombre);
            autorNuevo.setAlta(false);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardó el nuevo autor");
        }
    }

    public void listarAutores() {

        try {
            List<Autor> autores = autorDAO.listarAutores();
            imprimirLista(autores);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void imprimirLista(List<Autor> listaAutores) throws Exception {
        for (Autor autor : listaAutores) {
            System.out.println(autor.getId() + " - " + autor.getNombre() + " - " + autor.isAlta());
        }
    }

    public void darDeAltaBaja(Autor autor) {
        try {
            autorDAO.darDeAltaBaja(autor);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
