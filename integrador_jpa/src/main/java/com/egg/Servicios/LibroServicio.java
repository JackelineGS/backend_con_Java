package com.egg.Servicios;

import com.egg.Entidades.Autor;
import com.egg.Entidades.Editorial;
import com.egg.Entidades.Libro;
import com.egg.Persistencia.LibroDAO;
import java.util.List;

public class LibroServicio {
    private final LibroDAO daoLibro;// Instancio a la unidad d persistencia para acceder a los metodos del EM

  public LibroServicio(LibroDAO daoLibro) {
    this.daoLibro = daoLibro;
  }

  public void crearLibro(Boolean alta, int anio, int ejemplares, String titulo, Autor autor, Editorial editorial) {

    try {
      // Crear una nueva instancia de Libro
      Libro libroNuevo = new Libro();

      libroNuevo.setAlta(alta);
      libroNuevo.setAnio(anio);
      libroNuevo.setEjemplares(ejemplares);
      libroNuevo.setTitulo(titulo);
      libroNuevo.setAutor(autor);
      libroNuevo.setEditorial(editorial);

      // Llamar al método de OficinaDAO para guardar la nueva oficina
      daoLibro.guardarLibro(libroNuevo);

      System.out.println("Se guardo el libro correctamente.");

    } catch (Exception e) {
      System.out.println(e.toString() + "No se guardo el libro.");
    }
  }

  public Libro buscarLibro(Long isbn) {
    Libro libroBuscado = daoLibro.buscarLibro(isbn);

    try {
      if (libroBuscado == null) {
        System.out.println("No existe un libro con el ISBN proporcionado: " + isbn);
      }

      return libroBuscado;
    } catch (Exception e) {
      System.out.println("Ocurrio un error al buscar el libro: " + e.getMessage());
    }

    return null;
  }

  public void actualizarLibro(Libro libro) {
    try {
      if (daoLibro.buscarLibro(libro.getIsbn()) == null) {
        System.out.println("No existe un libro con el ISBN proporcionado: " + libro.getIsbn());
      } else {
        daoLibro.actualizarLibro(libro);
        System.out.println("Libro actualizado correctamente");
      }
    } catch (Exception e) {
      System.out.println("Error al actualizar el libro con ISBN: " + libro.getIsbn());
    }
  }

  public void eliminarLibro(Long isbn) {
    try {
      if (daoLibro.buscarLibro(isbn) == null) {
        System.out.println("No existe un libro con el ISBN proporcionado: " + isbn);
      } else {
        daoLibro.eliminarLibro(isbn);
        System.out.println("Libro con ISBN: " + isbn + " eliminado correctamente");
      }
    } catch (Exception e) {
      System.out.println("Error al eliminar el libro con isbn: " + isbn);
    }
  }

  public void listarLibros() throws Exception {
    List<Libro> todosLibros = daoLibro.listarTodos();
    imprimirLista(todosLibros);
  }

  public void imprimirLista(List<Libro> listaRecibida) throws Exception {
    for (Libro libro : listaRecibida) {
      System.out.println(libro.getIsbn() + " - " + libro.getTitulo() + " - "
          + libro.getAutor());
    }
  }
}
