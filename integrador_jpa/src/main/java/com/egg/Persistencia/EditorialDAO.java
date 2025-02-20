package com.egg.Persistencia;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.egg.Entidades.Editorial;


public class EditorialDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
    private final EntityManager em = emf.createEntityManager();

    public void guardarEditorial(Editorial editorial) {
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    public Editorial buscarEditorial(int id) {
        return em.find(Editorial.class, id);
    }

    public void actualizarEditorial(Editorial editorial) {
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
    }

    public void eliminarEditorial(int id) {
        Editorial editorial = em.find(Editorial.class, id);
        if (editorial != null) {
            em.getTransaction().begin();
                em.remove(editorial);
                em.getTransaction().commit();
            }
    }

    public List<Editorial> listarEditoriales() throws Exception {
        return em.createQuery("SELECT e FROM Editorial e", Editorial.class).getResultList();
    }
    
}
