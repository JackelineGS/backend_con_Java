package entidades;

public class Estancia {
    
    private int id_estancia;
    private int id_cliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    
    public Estancia(int id_estancia, int id_cliente, String nombre, String direccion, String telefono, String email) {
        this.id_estancia = id_estancia;
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    
    public Estancia() {
    }
    
    public int getId_estancia() {
        return id_estancia;
    }
    public void setId_estancia(int id_estancia) {
        this.id_estancia = id_estancia;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Estancias [id_estancia=" + id_estancia + ", id_cliente=" + id_cliente + ", nombre=" + nombre + ", direccion="
                + direccion + ", telefono=" + telefono + ", email=" + email + "]";
    }
}
