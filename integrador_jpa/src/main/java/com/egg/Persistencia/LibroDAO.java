package com.egg.Persistencia;

import com.egg.Entidades.Libro;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LibroDAO {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
  private final EntityManager em = emf.createEntityManager();

  public void guardarLibro(Libro libro) throws Exception {
    em.getTransaction().begin();
    em.persist(libro);
    em.getTransaction().commit();
  }

  public Libro buscarLibro(Long isbn) {
    return em.find(Libro.class, isbn);
  }

  public void actualizarLibro(Libro libro) {
    em.getTransaction().begin();
    em.merge(libro);
    em.getTransaction().commit();
  }

  public void eliminarLibro(Long isbn) {
    Libro libro = em.find(Libro.class, isbn);
    libro.setAlta(false);
    em.getTransaction().begin();
    em.remove(libro);
    em.getTransaction().commit();
  }

  public List<Libro> listarTodos() throws Exception {
    return em.createQuery("SELECT l FROM Libro l", Libro.class)
        .getResultList();
  }

  public List<Libro> buscarLibroPorTitulo(String titulo) {
    return em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo", Libro.class)
        .setParameter("titulo", titulo)
        .getResultList();
  }

}
