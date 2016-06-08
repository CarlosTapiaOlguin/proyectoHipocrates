package cl.duoc.agendamedica.modelo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Created by Administrador on 26-05-2016.
 */
@XmlRootElement
@Entity
@Table(name = "DOCTOR")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Doctor {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "NOMBRE")
    private String nombreCompleto;


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
