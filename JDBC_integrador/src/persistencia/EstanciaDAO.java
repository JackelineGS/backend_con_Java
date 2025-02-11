package persistencia;
import entidades.Estancia;
import persistencia.DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EstanciaDAO extends DAO {
    
    public List<Estancia> listarEstancias() throws Exception {

        List<Estancia> estancias = new ArrayList<>();
        String sql="SELECT * FROM estancias";

        try(ResultSet rs = ejecutarConsulta(sql)) {
            
            while (rs.next()) {
                Estancia estancia = new Estancia();
                estancia.setIdEstancia(rs.getInt("id_estancia"));
                estancia.setIdCliente(rs.getInt("id_cliente"));
                estancia.setIdCasa(rs.getInt("id_casa"));
                estancia.setNombre(rs.getString("nombre_huesped"));
                estancia.setFechaDesde(rs.getDate("fecha_desde"));
                estancia.setFechaHasta(rs.getDate("fecha_hasta"));
            }
        } 

        return estancias;
    }
}
