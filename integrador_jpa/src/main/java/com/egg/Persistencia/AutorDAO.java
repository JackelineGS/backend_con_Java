package com.egg.Persistencia;

import com.egg.Entidades.Autor;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AutorDAO {
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
	EntityManager em = emf.createEntityManager();

    public void guardaAutor(Autor autor) throws Exception {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public void actualizarAutor(Autor autor) {
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
    }

    public void eliminarAutor(int id) {
        Autor autor = em.find(Autor.class, id);
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
    }

    public List<Autor> listarAutores() throws Exception {
        return em.createQuery("SELECT a FROM Autor a", Autor.class)
        .getResultList();
    }

    public Autor buscarAutor(int id) throws Exception {
        return em.find(Autor.class, id);
    }
    
    public void darDeAltaBaja(Autor autor) {
        autor.setAlta(!autor.isAlta());
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
    }
}
