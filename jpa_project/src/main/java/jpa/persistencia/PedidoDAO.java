package jpa.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.entidades.Pedido;

public class PedidoDAO {

        private final EntityManagerFactory emf =
Persistence.createEntityManagerFactory("ViveroPU");
private final EntityManager em = emf.createEntityManager();

public void guardarPedido(Pedido pedido) {
em.getTransaction().begin();
em.persist(pedido);
em.getTransaction().commit();
}
public Pedido buscarPedido(int id) {
return em.find(Pedido.class, id);
}
public void actualizarOficina(Pedido pedido) {
em.getTransaction().begin();
em.merge(pedido);
em.getTransaction().commit();
}
public void eliminarOficina(int id) {
Pedido pedido = em.find(Pedido.class, id);
if (pedido != null) {
em.getTransaction().begin();
em.remove(pedido);
em.getTransaction().commit();
}
}
    
}
