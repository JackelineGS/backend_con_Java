package com.egg.biblioteca.controladores;

import java.util.logging.Logger;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.EditorialServicio;


@Controller
@RequestMapping("/editorial") //localhost:8080/editorial
public class EditorialControlador {
    
    @Autowired
    private EditorialServicio editorialServicio;

    @GetMapping("/registrar")
    public String registrar(){
        return "editorial_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre){
        //System.out.println("Editorial: " + nombre );
        try {
            editorialServicio.crearEditorial(nombre);
        } catch (MiException ex) {
            Logger.getLogger(EditorialControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "editorial_form.html";
        }
        return "index.html";
        //return "editorial_form.html";
    }
}
