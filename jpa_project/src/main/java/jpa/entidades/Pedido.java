package jpa.entidades;

import java.time.LocalDateTime;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private int idPedido;

    @Column(name = "codigo_pedido")
    private int codigoPedido;

    @Column(name = "comentarios")
    private String comentarios;

    @Column(name = "estado")
    private String estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_entrega")
    private LocalDateTime fechaEntrega;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_esperada")
    private LocalDateTime fechaEsperada;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_pedido")
    private LocalDateTime fechaPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detallePedidos;
    
    public Pedido() {
    }
    
    public Pedido(int codigoPedido, String comentarios, String estado, LocalDateTime fecha_entrega,
            LocalDateTime fecha_esperada, LocalDateTime fecha_pedido) {
        this.codigoPedido = codigoPedido;
        this.comentarios = comentarios;
        this.estado = estado;
        this.fechaEntrega = fecha_entrega;
        this.fechaEsperada = fecha_esperada;
        this.fechaPedido = fecha_pedido;
    }

    public Pedido(int idPedido, int codigoPedido, String comentarios, String estado, LocalDateTime fecha_entrega,
            LocalDateTime fecha_esperada, LocalDateTime fecha_pedido) {
        this.idPedido = idPedido;
        this.codigoPedido = codigoPedido;
        this.comentarios = comentarios;
        this.estado = estado;
        this.fechaEntrega = fecha_entrega;
        this.fechaEsperada = fecha_esperada;
        this.fechaPedido = fecha_pedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fecha_entrega) {
        this.fechaEntrega = fecha_entrega;
    }

    public LocalDateTime getFechaEsperada() {
        return fechaEsperada;
    }

    public void setFechaEsperada(LocalDateTime fecha_esperada) {
        this.fechaEsperada = fecha_esperada;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fecha_pedido) {
        this.fechaPedido = fecha_pedido;
    }
}
    
