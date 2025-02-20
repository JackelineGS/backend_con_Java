package com.egg;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
    EntityManager em = emf.createEntityManager();
    
    /*do {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Ingrese una opcion");
        int opcion = sc.nextInt();

        switch (sc) {
            case 1: 
                
                break;
        
            default:
                break;
        }

            
        } while()*/
}


    
    
}