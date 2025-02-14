package jpa.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private int idDetallePedido;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "numero_linea")
    private int numeroLinea;

    @Column(name = "precio_unidad")
    private double precioUnidad;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public DetallePedido() {}


    public DetallePedido(int cantidad, int numeroLinea, double precioUnidad) {
        this.cantidad = cantidad;
        this.numeroLinea = numeroLinea;
        this.precioUnidad = precioUnidad;
    }

    public DetallePedido(int idDetallePedido, int cantidad, int numeroLinea, double precioUnidad) {
        this.idDetallePedido = idDetallePedido;
        this.cantidad = cantidad;
        this.numeroLinea = numeroLinea;
        this.precioUnidad = precioUnidad;
    }

    public int getIdDetallePedido() {
        return idDetallePedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setIdDetallePedido(int idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
            "idDetallePedido=" + idDetallePedido +
            ", cantidad=" + cantidad +
            ", precioUnidad=" + precioUnidad +
            ", numeroLinea=" + numeroLinea +
            '}';
    }
}
