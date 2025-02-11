package entidades;


public class Cliente {
    
    private  int idCliente;
    private  String nombre;
    private  int numero;
    private  String calle;
    private  String codigoPostal;
    private  String ciudad;
    private  String pais;
    private  String email;

    public Cliente(int idCliente, String nombre, int numero, String calle, String codigoPostal, String ciudad,
            String pais, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.numero = numero;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.pais = pais;
        this.email = email;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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
        return "Clientes [id_cliente=" + idCliente + ", nombre=" + nombre + ", numero=" + numero + ", calle=" + calle
                + ", codigo_postal=" + codigoPostal + ", ciudad=" + ciudad + ", pais=" + pais + ", email=" + email
                + "]";
    }

}
