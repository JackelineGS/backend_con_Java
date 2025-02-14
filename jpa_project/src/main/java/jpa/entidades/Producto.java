package jpa.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(name = "cantidad_en_stock")
    private int cantidadEnStock;
    
    @Column(name = "codigo_producto")
    private String codigoProducto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "dimensiones")
    private String dimensiones;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio_proveedor")
    private int precioProveedor;
    
    @Column(name = "precio_venta")
    private int precioVenta;

    @Column(name = "proveedor")
    private String proveedor;

    @ManyToOne
    @JoinColumn(name = "id_gama")
    private GamaProducto gamaProducto;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detallePedidos;
    
    public Producto() {
    }

    public Producto(int cantidadEnStock, String codigoProducto, String descripcion, String dimensiones, String nombre,
            int precioProveedor, int precioVenta, String proveedor, GamaProducto gamaProducto) {
        this.cantidadEnStock = cantidadEnStock;
        this.codigoProducto = codigoProducto;
        this.descripcion = descripcion;
        this.dimensiones = dimensiones;
        this.nombre = nombre;
        this.precioProveedor = precioProveedor;
        this.precioVenta = precioVenta;
        this.proveedor = proveedor;
        this.gamaProducto = gamaProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getprecioProveedor() {
        return precioProveedor;
    }

    public void setprecioProveedor(int precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public int getprecioVenta() {
        return precioVenta;
    }

    public void setprecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public GamaProducto getGamaProducto() {
        return gamaProducto;
    }

    public void setGamaProducto(GamaProducto gamaProducto) {
        this.gamaProducto = gamaProducto;
    }

    
    
}

