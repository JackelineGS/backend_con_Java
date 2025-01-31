package coneccionjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class buscarClientes {

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
    
}
