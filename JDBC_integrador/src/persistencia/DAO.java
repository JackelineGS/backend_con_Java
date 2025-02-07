package persistencia;
import java.sql.*;

public abstract class DAO {
    
    private static Connection conexion = null;

    private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DATABASE = "estancias_exterior";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String ZONA = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + ZONA;

    protected static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        if (conexion == null || conexion.isClosed()) {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión establecida.");
        }
        return conexion;
    }

    protected static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                conexion = null;
                System.out.println("🔴 Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("⚠️ Error al cerrar la conexión: " + e.getMessage());
        }
    }

    protected void ejecutarModificacion(String sql) throws Exception {
        try (Connection conn = obtenerConexion();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("✅ Operación realizada con éxito.");
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("⚠️ Error en la base de datos: " + ex.getMessage());
            throw ex;
        }
    }

    protected ResultSet ejecutarConsulta(String sql) throws Exception {
        try {
            Connection conn = obtenerConexion();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("⚠️ Error en la consulta: " + ex.getMessage());
            throw ex;
        }
    }
}
