package persistencia;
import java.util.ArrayList;
import java.util.List;
import entidades.Cliente;

public class ClienteDAO extends DAO {

     List<Cliente> listaClientes = new ArrayList<>();
     //listaClientes.add(new Cliente(id, nombre, apellido));
    

//listarTodosLosClientes: Este método será responsable de consultar la base de datos 
//y recuperar los clientes registrados. En caso de que existan registros en la tabla, se recuperarán los campos id, nombre y apellido de cada cliente y se almacenarán en una lista de objetos Cliente.

//Crea una sentencia SQL para consultar los campos id, nombre y apellido de la 
//tabla clientes

//Ejecutar la consulta y obtener los resultados: Utiliza el método executeQuery() 
//para ejecutar la consulta. Esto devolverá un ResultSet que contiene los resultados de la consulta.

//Añadir los registros a la lista de Cliente: Recorre el ResultSet y, para cada fila, 
//crea un nuevo objeto Cliente utilizando los valores de los campos id, nombre y apellido. 
//Agrega cada objeto Cliente a una lista de clientes.

//Imprimir la lista de clientes: Si la lista de clientes no está vacía, recórrela 
//para imprimir la información de cada cliente. Para esto, puedes crear un método en la 
//clase Cliente que imprima solo los campos utilizados en esta actividad.

//Manejo de excepciones: Asegúrate de manejar las excepciones, como SQLException, 
//que podrían ocurrir durante la ejecución de la sentencia SQL. 
//Captura estas excepciones y maneja el error de forma adecuada, 
//por ejemplo, registrando el error o lanzando una excepción personalizada.

public void guardarCliente(Cliente cliente) throws Exception{

    if (cliente==null) {
    throw new Exception("Cliente no puede ser nulo");
    } else {
    
    String sql="INSERT INTO cliente (codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, ciudad, region, país, codigo_postal,id_empleado, limite_credito) VALUES ('"+cliente.getCodigoCliente()+"', '"+cliente.getNombreCliente()+"','"+cliente.getApellidoContacto()+"','"+cliente.getTelefono()+"','"
    +cliente.getFax()+"','"+cliente.getCiudad()+"','"+cliente.getRegion()+"','"+cliente.getPais()+"','"
    +cliente.getCodigoPostal()+"','"+cliente.getIdEmpleado()+"','"+cliente.getLimiteCredito()+"')";
    insertarModificarEliminarDataBase(sql);
    }
    }


public List<Cliente> listarTodosLosClientes() throws Exception {

    String sql="SELECT id_cliente, nombre_cliente, nombre_contacto, apellido_contacto FROM cliente";
    consultarDataBase(sql);
    List<Cliente> clientes = new ArrayList<>(); 
    
    while (resultSet.next()) {

        Cliente cliente = new Cliente();
        cliente.setIdCliente(resultSet.getInt("id_cliente"));
        cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
        cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
        cliente.setApellidoContacto(resultSet.getString("apellido_contacto")); 
        clientes.add(cliente);
        System.out.println(cliente.toString());
    }
        return clientes;

    }

    /*public List<Cliente> listarTodosLosCLientes() throws Exception{

        String sql="SELECT id_cliente,nombre_cliente, nombre_contacto, apellido_contacto FROM cliente";
        consultarDataBase(sql);
        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(resultSet.getInt("id_cliente"));
        cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
        cliente.setNombreContacto(resultSet.getString("nombre_contacto"));
        cliente.setApellidoContacto(resultSet.getString("apellido_contacto"));
        clientes.add(cliente);
        System.out.println(cliente.toString());
        System.out.println(" ");
        }
        return clientes;
        
        }*/
}
