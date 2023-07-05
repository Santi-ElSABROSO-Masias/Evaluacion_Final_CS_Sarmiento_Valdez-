/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author USUARIO
 */

@Entity
@Table(catalog = "Personajpa", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Prueba.seleccionaTodos", query = "SELECT p FROM Prueba p"),
    @NamedQuery(name = "Prueba.seleccionaPorId", query = "SELECT p FROM Prueba p WHERE p.pruebaId = :pruebaId")
})
public class Personajpa {
    
}
