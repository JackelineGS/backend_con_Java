package entidades;

public class Comentario {

    private int id_comentario;
    private int id_cliente;
    private String comentario;
    
    public Comentario(int id_comentario, int id_cliente, String comentario) {
        this.id_comentario = id_comentario;
        this.id_cliente = id_cliente;
        this.comentario = comentario;
    }
    
    public Comentario() {
    }
    
    public int getId_comentario() {
        return id_comentario;
    }
    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario [id_comentario=" + id_comentario + ", id_cliente=" + id_cliente + ", comentario=" + comentario
                + "]";
    }
    
    
}
