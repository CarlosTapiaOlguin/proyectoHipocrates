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
@Table(name = "PROVINCIAS")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Provincia implements Serializable{

    @Id
    @GeneratedValue(generator="SEQ_PROVINCIAS")
    @SequenceGenerator(name="SEQ_PROVINCIAS",sequenceName="SEQ_PROVINCIAS", allocationSize=1)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "REGION_ID")
    private int idRegion;

    @OneToMany
    @JoinColumn(name="PROVINCIA_ID", referencedColumnName="ID")
    private List<Comuna> comunas;


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

    public List<Comuna> getComunas() {
        return comunas;
    }

    public void setComunas(List<Comuna> comunas) {
        this.comunas = comunas;
    }
}
