package com.egg.Servicios;
import java.util.List;
import com.egg.Entidades.Editorial;
import com.egg.Persistencia.EditorialDAO;


public class EditorialServicio {

    private final EditorialDAO editorialDAO;

    public EditorialServicio(){
        this.editorialDAO = new EditorialDAO();
    }

    public void guardarEditorial(String nombre, Boolean alta){
        try {
            Editorial editorialNuevo = new Editorial();
            editorialNuevo.setNombre(nombre);
            editorialNuevo.setAlta(false);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardó el nuevo editorial");
        }
    }

    public void listarEditoriales() {
        
        try {
            List<Editorial> editoriales = editorialDAO.listarEditoriales();
            imprimirLista(editoriales);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void imprimirLista(List<Editorial> listaEditoriales) throws Exception {
        for(Editorial editorial : listaEditoriales) {
            System.out.println(editorial.getId() + " - " + editorial.getNombre() + " - " + editorial.isAlta());
        }
    }
    
}
