package servicios;
import entidades.Pedido;
import persistencia.PedidoDAO;
import java.sql.Date;

public class PedidoServicio {
    private PedidoDAO pedidoDao;
    public  PedidoServicio(){
        this.pedidoDao =  new PedidoDAO();
    }
    public Pedido crearNuevoPedido(int idPedido, int codigoPedido, Date fechaPedido, Date fechaEsperada, Date fechaEntrega,
            String estado, String comentarios, int idCliente) throws Exception {
        // Validaciones - Pueden estar metodo independiente.
        validacionesFecha(fechaPedido);

        //public Pedido(int idPedido, int codigoPedido, Date fechaPedido, Date fechaEsperada, Date fechaEntrega,
        //String estado, String comentarios, int idCliente)


        Pedido pedido = new Pedido(idPedido, codigoPedido, fechaPedido, fechaEsperada, fechaEntrega, estado, comentarios, idCliente);
        pedidoDao.guardarPedido(pedido);
        return pedido;
    }
    public void validacionesFecha(Date fecha_de_pedido) throws Exception{
        if (fecha_de_pedido == null) {
            throw new Exception("La fecha del pedido no puede ser nulo.");
        }
    }
}
