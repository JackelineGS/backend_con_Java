package jpa;
import jpa.servicios.OficinaServicio;

public class Main {

    public static void main(String[] args) {
        // Instanciar la clase OficinaServicio para acceder a sus métodos
        OficinaServicio oficinaServicio = new OficinaServicio();


        // Llamar al método del servicio para crear una nueva oficina
        oficinaServicio.crearOficna("OFI01", "Mendoza", "Argentina", "Cuyo", "11111111",
                "CP5000");


    }
}