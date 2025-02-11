package persistencia;
import entidades.Familia;
import persistencia.DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FamiliaDAO extends DAO {

 
public List<Familia> listarFamilias() throws Exception {
    
    List<Familia> familias = new ArrayList<>();
    String sql="SELECT * FROM familias";
    
        try(ResultSet rs = ejecutarConsulta(sql)){

            while(rs.next()){
                Familia familia = new Familia();
                familia.setIdFamilia(rs.getInt("id_familia"));
                familia.setNombre(rs.getString("nombre"));
                familia.setEdadMinima(rs.getInt("edad_minima"));
                familia.setEdadMaxima(rs.getInt("edad_maxima"));
                familia.setNumHijos(rs.getInt("num_hijos"));
                familia.setEmail(rs.getString("email"));
                familia.setIdCasaFamilia(rs.getInt("id_casa_familia"));
                familias.add(familia);
            }
        }
        return familias;

    }
    
}