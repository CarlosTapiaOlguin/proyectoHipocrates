package cl.duoc.agendamedica.modelo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrador on 13-07-2016.
 */
@XmlRootElement
@Entity
@Table(name = "ISAPRES")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Prevision implements Serializable{

    @Id
    @GeneratedValue(generator="SEQ_ISAPRES")
    @SequenceGenerator(name="SEQ_ISAPRES",sequenceName="SEQ_ISAPRES", allocationSize=1)
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
