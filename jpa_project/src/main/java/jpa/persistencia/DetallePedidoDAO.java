package jpa.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DetallePedidoDAO {

        private final EntityManagerFactory emf =
Persistence.createEntityManagerFactory("ViveroPU");
private final EntityManager em = emf.createEntityManager();

public void guardarDetallePedido(DetallePedidoDAO detallePedidoDAO) {
em.getTransaction().begin();
em.persist(detallePedidoDAO);
em.getTransaction().commit();
}
public DetallePedidoDAO buscarDetallePedidoDAO(int id) {
return em.find(DetallePedidoDAO.class, id);
}
public void actualizarDetallePedido(DetallePedidoDAO detallePedidoDAO) {
em.getTransaction().begin();
em.merge(detallePedidoDAO);
em.getTransaction().commit();
}
public void eliminarDetallePedido(int id) {
DetallePedidoDAO detallePedidoDAO = em.find(DetallePedidoDAO.class, id);
if (detallePedidoDAO != null) {
em.getTransaction().begin();
em.remove(detallePedidoDAO);
em.getTransaction().commit();
}
}
    
}
