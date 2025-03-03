package jpa.persistencia;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.entidades.Producto;

public class ProductoDAO {

        private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
        private final EntityManager em = emf.createEntityManager();

        public void guardarProducto(Producto producto) {
                em.getTransaction().begin();
                em.persist(producto);
                em.getTransaction().commit();
        }

        public Producto buscarProducto(int id) {
                return em.find(Producto.class, id);
        }

        public void actualizarProducto(Producto producto) {
                em.getTransaction().begin();
                em.merge(producto);
                em.getTransaction().commit();
        }

        public void eliminarProducto(int id) {
                Producto producto = em.find(Producto.class, id);
                if (producto != null) {
                        em.getTransaction().begin();
                        em.remove(producto);
                        em.getTransaction().commit();
                }
        }

        public List<Producto> listarProductos() throws Exception {
                return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        }

}
