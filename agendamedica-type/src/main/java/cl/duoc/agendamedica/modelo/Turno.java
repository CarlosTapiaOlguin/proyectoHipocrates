package cl.duoc.agendamedica.modelo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Administrador on 12-07-2016.
 */
@XmlRootElement
@Entity
@Table(name = "TURNOS")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Turno implements Serializable{

    @Id
    @GeneratedValue(generator="SEQ_TURNOS")
    @SequenceGenerator(name="SEQ_TURNOS",sequenceName="SEQ_TURNOS", allocationSize=1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ESTADO_TURNO_ID")
    private Integer estado;


    @Column(name = "HORA_INICIO")
    private String horaInicio;


    @Column(name = "HORA_FIN")
    private String horaFin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
}
