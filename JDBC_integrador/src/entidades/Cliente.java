package entidades;


public class Cliente {
    
    private  int id_cliente;
    private  String nombre;
    private  int numero;
    private  String calle;
    private  String codigo_postal;
    private  String ciudad;
    private  String pais;
    private  String email;

    public Cliente(int id_cliente, String nombre, int numero, String calle, String codigo_postal, String ciudad,
            String pais, String email) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.numero = numero;
        this.calle = calle;
        this.codigo_postal = codigo_postal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.email = email;
    }

    public Cliente() {
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
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getCodigo_postal() {
        return codigo_postal;
    }
    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Clientes [id_cliente=" + id_cliente + ", nombre=" + nombre + ", numero=" + numero + ", calle=" + calle
                + ", codigo_postal=" + codigo_postal + ", ciudad=" + ciudad + ", pais=" + pais + ", email=" + email
                + "]";
    }

}
