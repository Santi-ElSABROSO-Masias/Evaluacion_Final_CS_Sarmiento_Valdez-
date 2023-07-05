package agenda.entidadjpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import agenda.control.PersonEditDialogController;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(catalog = "agendafxgpa", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Persona.seleccionaTodos", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.seleccionaPorId", query = "SELECT p FROM Persona p WHERE p.personaId = :personaId"),
    @NamedQuery(name = "Persona.seleccionaPorApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos")})

/**
 *
 * @author USUARIO
 */
public class EntidadPersona implements Serializable 
{

    @Id
    private Long id;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "persona_id", nullable = false)
    private Integer nombreField;
    @Column(length = 30)
    private String apellidoField;
    @Column(length = 60)
    private String calleField;
    @Column(length = 50)
    private String codigoPostalField;
    @Column(length = 100)
    private String cuidadField;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Column(length = 15)
    private String cumpleañosField;
    
    
    
        public EntidadPersona(Long id, Integer nombreField, String apellidoField, String calleField, String codigoPostalField, String cuidadField, Date fechaNacimiento, String cumpleañosField) {
        this.id = id;
        this.nombreField = nombreField;
        this.apellidoField = apellidoField;
        this.calleField = calleField;
        this.codigoPostalField = codigoPostalField;
        this.cuidadField = cuidadField;
        this.fechaNacimiento = fechaNacimiento;
        this.cumpleañosField = cumpleañosField;
    }

    public void setNombreField(Integer nombreField) {
        this.nombreField = nombreField;
    }

    public void setApellidoField(String apellidoField) {
        this.apellidoField = apellidoField;
    }

    public void setCalleField(String calleField) {
        this.calleField = calleField;
    }

    public void setCodigoPostalField(String codigoPostalField) {
        this.codigoPostalField = codigoPostalField;
    }

    public void setCuidadField(String cuidadField) {
        this.cuidadField = cuidadField;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCumpleañosField(String cumpleañosField) {
        this.cumpleañosField = cumpleañosField;
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getNombreField() {
        return nombreField;
    }

    public String getApellidoField() {
        return apellidoField;
    }

    public String getCalleField() {
        return calleField;
    }

    public String getCodigoPostalField() {
        return codigoPostalField;
    }

    public String getCuidadField() {
        return cuidadField;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCumpleañosField() {
        return cumpleañosField;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
 
       
}
