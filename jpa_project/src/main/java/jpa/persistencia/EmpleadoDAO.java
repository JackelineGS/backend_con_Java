package jpa.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.entidades.Empleado;

public class EmpleadoDAO {

        private final EntityManagerFactory emf =
Persistence.createEntityManagerFactory("ViveroPU");
private final EntityManager em = emf.createEntityManager();

public void guardarEmpleado(Empleado empleado) {
em.getTransaction().begin();
em.persist(empleado);
em.getTransaction().commit();
}
public Empleado buscarEmpleado(int id) {
return em.find(Empleado.class, id);
}
public void actualizarEmpleado(Empleado empleado) {
em.getTransaction().begin();
em.merge(empleado);
em.getTransaction().commit();
}
public void eliminarEmpleado(int id) {
Empleado empleado = em.find(Empleado.class, id);
if (empleado != null) {
em.getTransaction().begin();
em.remove(empleado);
em.getTransaction().commit();
}
}
    
}
