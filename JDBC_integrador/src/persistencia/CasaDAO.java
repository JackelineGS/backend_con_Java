package persistencia;
import entidades.Casa;
import entidades.Familia;
import persistencia.DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CasaDAO extends DAO {


    public List<Casa> listarCasas() throws Exception {

        List<Casa> casas = new ArrayList<>();
        String sql="SELECT * FROM casas";

            try(ResultSet rs = ejecutarConsulta(sql)){
            
                while(rs.next()){
        
                Casa casa = new Casa();
        casa.setIdCasa(rs.getInt("id_casa"));
        casa.setCalle(rs.getString("calle"));
        casa.setNumero(rs.getInt("numero"));
        casa.setCodigoPostal(rs.getString("codigo_postal"));
        casa.setCiudad(rs.getString("ciudad"));
        casa.setPais(rs.getString("pais"));
        casa.setFechaDesde(rs.getDate("fecha_desde"));
        casa.setFechaHasta(rs.getDate("fecha_hasta"));
        casa.setTiempoMinimo(rs.getInt("tiempo_minimo"));
        casa.setTiempoMaximo(rs.getInt("tiempo_maximo"));
        casa.setPrecioHabitacion(rs.getDouble("precio_habitacion"));
        casa.setTipoVivienda(rs.getString("tipo_vivienda"));
     }
 }
        return casas;
    }
    
}
