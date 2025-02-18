package jpa.persistencia;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.entidades.Cliente;

public class ClienteDAO {
        private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
        private final EntityManager em = emf.createEntityManager();

        public void guardarCliente(Cliente cliente) {
                em.getTransaction().begin();
                em.persist(cliente);
                em.getTransaction().commit();
        }

        public Cliente buscarCliente(int id) {
                return em.find(Cliente.class, id);
        }

        public void actualizarCliente(Cliente cliente) {
                em.getTransaction().begin();
                em.merge(cliente);
                em.getTransaction().commit();
        }

        public void eliminarCliente(int id) {
                Cliente cliente = em.find(Cliente.class, id);
                if (cliente != null) {
                        em.getTransaction().begin();
                        em.remove(cliente);
                        em.getTransaction().commit();
                }
        }

        public List<Cliente> listarClientes() throws Exception {
                return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        }

}
