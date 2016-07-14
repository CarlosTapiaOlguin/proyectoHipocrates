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
@Table(name = "ESPECIALIDADES")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Especialidad implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQ_ESPECIALIDADES")
    @SequenceGenerator(name = "SEQ_ESPECIALIDADES", sequenceName = "SEQ_ESPECIALIDADES", allocationSize = 1)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "LABORATORIO")
    private String laboratorio;

    @Column(name = "LIMITE")
    private Integer limite;

    @ManyToMany
    @JoinTable(
            name="DOCTORES",
            joinColumns=@JoinColumn(name="ESPECIALIDAD_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="USUARIO_ID", referencedColumnName="ID"))
    private List<Usuario> doctores;


    public List<Usuario> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<Usuario> doctores) {
        this.doctores = doctores;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

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
