package persistencia;
import entidades.Comentario;
import persistencia.DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO extends DAO {

    List<Comentario> listaComentarios() throws Exception {

        List<Comentario> comentarios = new ArrayList<>();
        String sql="SELECT * FROM comentarios";

        try (ResultSet rs = ejecutarConsulta(sql)) {
            while (rs.next()) {
                Comentario comentario = new Comentario();
                comentario.setIdComentario(rs.getInt("id_comentario"));
                comentario.setIdCasa(rs.getInt("id_casa"));
                comentario.setComentario(rs.getString("comentario"));
                comentarios.add(comentario);
            }
        } 
        return comentarios;
    }
    
}
