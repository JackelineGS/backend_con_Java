package coneccionjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        Connection db = getConnection();
        if (db != null) {
            tmp();
            closeConnection(db);
        }
    }

    public static void tmp() {
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id_cliente, codigo_cliente, nombre_cliente FROM cliente")) {

            while (rs.next()) {
                int x = rs.getInt("id_cliente");
                String s = rs.getString("codigo_cliente");
                String d = rs.getString("nombre_cliente");
                System.out.println("Fila = " + x + " " + s + " " + d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        String host = "127.0.0.1";
        String port = "";
        String user = "";
        String password = ""; 
        String database = "";

        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&serverTimezone=UTC";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida exitosamente.");
            return connection;
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}