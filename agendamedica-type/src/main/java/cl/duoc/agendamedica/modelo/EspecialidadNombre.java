package cl.duoc.agendamedica.modelo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrador on 26-05-2016.
 */
@XmlRootElement
@Entity
@Table(name = "ESPECIALIDADES")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class EspecialidadNombre implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQ_ESPECIALIDADES")
    @SequenceGenerator(name = "SEQ_ESPECIALIDADES", sequenceName = "SEQ_ESPECIALIDADES", allocationSize = 1)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
