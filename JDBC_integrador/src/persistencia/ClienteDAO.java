package persistencia;
import entidades.Cliente;
import persistencia.DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO {

    public List<Cliente> listarClientes() throws Exception {

        List<Cliente> clientes = new ArrayList<>();
        String sql="SELECT * FROM familias";

        try (ResultSet rs = ejecutarConsulta(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCalle(rs.getString("calle"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setCodigoPostal(rs.getString("codigo_postal"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setPais(rs.getString("pais"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
            
        } 

        return clientes;
    } 
}
