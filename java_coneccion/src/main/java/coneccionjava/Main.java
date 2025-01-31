package coneccionjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
        public static void main(String[] args) throws Exception {
       Connection conexion = getConnection();
       //buscarClientes(conexion);
       //buscarClientePorCodigo(4, conexion);
       buscarClientePorIdEmpleado(13, conexion);
       cerrarConexion(conexion);
       
   }
   
   public static Connection getConnection() {
       String host = "127.0.0.1"; // localhost
       String port = "3306"; // por defecto es el puerto que utiliza
       String name = ""; // usuario de la base de datos
       String password = ""; // password de la base de datos
       String database = ""; // nombre de la base de datos recien creada, en este caso vivero.
       // Esto especifica una zona horaria, no es obligatorio de utilizar, pero en
       // algunas zonas genera conflictos de conexión si no existiera
       String zona = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
       String url = "jdbc:mysql://" + host + ":" + port + "/" + database + zona;
       // esto indica la ruta de conexion, que es la combinacion de
       // host,usuario,puerto, nombre de la base de datos a la cual queremos
       // conectarnos y la zona horaria (si se precisara).
       Connection conexion = null;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conexion = DriverManager.getConnection(url, name, password);
           System.out.println("Conexión exitosa a la base de datos.");
       } catch (ClassNotFoundException e) {
           System.out.println("Error al cargar el conector JDBC: " + e.getMessage());
       } catch (SQLException e) {
           System.out.println("Error de conexión: " + e.getMessage());
       }
       return conexion;
   }
   public static void cerrarConexion(Connection conexion) {
       if (conexion != null) {
           try {
               conexion.close();
               System.out.println("La conexión a la base de datos fue cerrada de manera exitosa");
           } catch (SQLException e) {
               System.out.println("Error al cerrar la conexión:" + e.getMessage());
           }
       }
   }      
   
   // Buscar clientes
    
   public static void buscarClientes(Connection conexion) {
     String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente ";
     try {
     Statement stmt = conexion.createStatement();
     ResultSet rs = stmt.executeQuery(sql);
     int count = 0;
     while (rs.next()) {
        String nombre = rs.getString("nombre_contacto");
        String apellido = rs.getString("apellido_contacto");
        String telefono = rs.getString("telefono");
        count++;
        System.out.println(count + " - " + nombre + " " + apellido + " - " + telefono);
     }
     // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
     rs.close();
     stmt.close();
     } catch (SQLException e) {
     System.out.println("Error en la consulta: " + e.getMessage());
     }
     }
 
     /// Buscar cliente por Codigo
     public static void buscarClientePorCodigo(int codigo, Connection conexion) {
        String sql = "SELECT * FROM cliente WHERE codigo_cliente = " + codigo;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                int codigo_cliente = rs.getInt("codigo_cliente");
                String nombre_cliente = rs.getString("nombre_cliente");
                String apellido_contacto = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                String fax = rs.getString("nombre_cliente");
                String ciudad = rs.getString("ciudad");
                String region = rs.getString("region");
                String pais = rs.getString("pais");
                String codigo_postal = rs.getString("codigo_postal");
                int id_empleado = rs.getInt("id_empleado");
                Double limite_credito = rs.getDouble("limite_credito");
                count++;
                System.out.println(id_cliente + " - " + nombre_cliente + " " + apellido_contacto + " - " + telefono);
             }
             // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
             rs.close();
             stmt.close();

        } catch (SQLException e) {
            System.out.println("Error al hacer la solicitud" + e.getMessage());
        }
     }

     //Realiza un método llamado buscarClientePorCodigo(codigo) que reciba como parámetro el código del cliente y muestre por pantalla los datos que tiene el cliente guardado en la base de datos. 

    //Realiza un método llamado  buscarClientesPorEmpleado(codigo) que reciba el código del empleado como parámetro 
    //y muestre todos los clientes asociados a un empleado en particular. 
    //Puedes elegir qué campos mostrar en tu método.

    public static void buscarClientePorIdEmpleado(int codigo, Connection conexion) {
        String sql = "SELECT * FROM cliente WHERE id_empleado = " + codigo;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                int codigo_cliente = rs.getInt("codigo_cliente");
                String nombre_cliente = rs.getString("nombre_cliente");
                String apellido_contacto = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                String fax = rs.getString("nombre_cliente");
                String ciudad = rs.getString("ciudad");
                String region = rs.getString("region");
                String pais = rs.getString("pais");
                String codigo_postal = rs.getString("codigo_postal");
                int id_empleado = rs.getInt("id_empleado");
                Double limite_credito = rs.getDouble("limite_credito");
                count++;
                System.out.println(count + " - " + id_empleado + " - " + nombre_cliente + " " + apellido_contacto + " - " + telefono);
             }
             // Cerrar ResultSet y Statement dentro del bloque try-catch-finally
             rs.close();
             stmt.close();
        } catch (SQLException e) {
            System.out.println("Error al hacer la solicitud" + e.getMessage());
        }
     }

}
