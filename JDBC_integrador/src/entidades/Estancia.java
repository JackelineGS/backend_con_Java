package entidades;
import java.util.Date;

public class Estancia {
    
    private int idEstancia;
    private int idCliente;
    private int idCasa;
    private String nombre;
    private Date fechaDesde;
    private Date fechaHasta;
    
    
    public Estancia(int idEstancia, int idCliente, int idCasa, String nombre, Date fechaDesde, Date fechaHasta) {
        this.idEstancia = idEstancia;
        this.idCliente = idCliente;
        this.idCasa = idCasa;
        this.nombre = nombre;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public Estancia() {
    }


    public int getIdEstancia() {
        return idEstancia;
    }

    public void setIdEstancia(int idEstancia) {
        this.idEstancia = idEstancia;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public String toString() {
        return "Estancia [idEstancia=" + idEstancia + ", idCliente=" + idCliente + ", idCasa=" + idCasa + ", nombre="
                + nombre + ", fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + "]";
    }
}
