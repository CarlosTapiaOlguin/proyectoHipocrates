package cl.duoc.agendamedica.modelo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by Administrador on 26-05-2016.
 */
@XmlRootElement
@Entity
@Table(name = "REGIONES")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Region implements Serializable{

    @Id
    @GeneratedValue(generator="SEQ_REGIONES")
    @SequenceGenerator(name="SEQ_REGIONES",sequenceName="SEQ_REGIONES", allocationSize=1)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany
    @JoinColumn(name="REGION_ID", referencedColumnName="ID")
    private List<Provincia> provincias;


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

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }
}
