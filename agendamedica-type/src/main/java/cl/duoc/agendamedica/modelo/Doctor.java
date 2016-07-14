package cl.duoc.agendamedica.modelo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Administrador on 12-07-2016.
 */
@XmlRootElement
@Entity
@Table(name = "DOCTORES")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Doctor implements Serializable{

    @Id
    @GeneratedValue(generator="SEQ_DOCTORES")
    @SequenceGenerator(name="SEQ_DOCTORES",sequenceName="SEQ_DOCTORES", allocationSize=5)
    @Column(name = "ID")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "ESPECIALIDAD_ID")
    private EspecialidadNombre especialidad;

    @Column(name = "OFICINA_ID")
    private Integer oficinaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EspecialidadNombre getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadNombre especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getOficinaId() {
        return oficinaId;
    }

    public void setOficinaId(Integer oficinaId) {
        this.oficinaId = oficinaId;
    }
}
