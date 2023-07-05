/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda.controljpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import agenda.modelo.Persona;
/**
 *
 * @author USUARIO
 */
public class ControladorJPA {
   
    private EntityManagerFactory emf;    
    ControladorJPA (){
        this.emf = Persistence.createEntityManagerFactory("BaseDatos");
    } 
}
