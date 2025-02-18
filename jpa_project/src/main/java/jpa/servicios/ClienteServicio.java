package jpa.servicios;
import java.util.List;
import jpa.entidades.Cliente;
import jpa.persistencia.ClienteDAO;

public class ClienteServicio {
     private final ClienteDAO clienteDAO;

    public ClienteServicio() {
        this.clienteDAO = new ClienteDAO();
    }

    public void guardarCliente(String apellidoContacto, String ciudad, int codigoCliente, String codigoPostal, String fax, int idEmpleado, double limiteCredito, String nombreCliente, String nombreContacto, String pais, String region, String telefono) {
        try {

            Cliente clienteNuevo = new Cliente();

            clienteNuevo.setApellidoContacto(apellidoContacto);
            clienteNuevo.setCiudad(ciudad);
            clienteNuevo.setCodigoCliente(codigoCliente);
            clienteNuevo.setCodigoPostal(codigoPostal);
            clienteNuevo.setFax(fax);
            clienteNuevo.setIdEmpleado(idEmpleado);
            clienteNuevo.setLimiteCredito(limiteCredito);
            clienteNuevo.setNombreCliente(nombreCliente);
            clienteNuevo.setNombreContacto(nombreContacto);
            clienteNuevo.setPais(pais);
            clienteNuevo.setRegion(region);
            clienteNuevo.setTelefono(telefono);
            clienteDAO.guardarCliente(clienteNuevo);
            
        } catch (Exception e) {
            System.out.println(e.toString() + " No se guardó el nuevo cliente de manera correcta.");
        }
    }

    public void listarClientes() {
        
        try {
            List<Cliente> clientes = clienteDAO.listarClientes();
            imprimirLista(clientes);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    
    }

    public void imprimirLista(List<Cliente> listaClientes) throws Exception {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.getApellidoContacto() + " - " + cliente.getCiudad() + " - " + cliente.getTelefono());
        }
    }
}
