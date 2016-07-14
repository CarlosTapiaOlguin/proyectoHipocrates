package cl.duoc.agendamedica.modelo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Administrador on 26-05-2016.
 */
@XmlRootElement
@Entity
@Table(name = "PACIENTES")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Paciente implements Serializable{

    @Id
    @GeneratedValue(generator="SEQ_PACIENTES")
    @SequenceGenerator(name="SEQ_PACIENTES",sequenceName="SEQ_PACIENTES", allocationSize=1)
    @Column(name = "ID")
    private int id;

    @OneToOne
    @JoinColumn(name = "ISAPRE_ID")
    private Prevision prevision;

    @OneToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Prevision getPrevision() {
        return prevision;
    }

    public void setPrevision(Prevision prevision) {
        this.prevision = prevision;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
