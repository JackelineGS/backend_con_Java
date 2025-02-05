import entidades.Cliente;
import persistencia.ClienteDAO;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ClienteDAO clientes = new ClienteDAO();
        clientes.listarTodosLosClientes();
        /*clientes.guardarCliente(new Cliente(99,"pedro","juan"
        ,"perez","45645985","4564513","Santiago","Texas","USA","123asd",9,55.56));*/
        
    }
}
