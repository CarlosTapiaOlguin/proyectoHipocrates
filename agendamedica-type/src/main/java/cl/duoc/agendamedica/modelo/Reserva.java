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
@Table(name = "RESERVAS")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Reserva implements Serializable{

    @Id
    @GeneratedValue(generator="SEQ_RESERVAS")
    @SequenceGenerator(name="SEQ_RESERVAS",sequenceName="SEQ_RESERVAS", allocationSize=1)
    @Column(name = "ID")
    private int id;

    @Column(name = "AGENDA_ID")
    private Integer agenda;

    @Column(name = "PACIENTE_ID")
    private Integer paciente;

    @Column(name = "ESTADO_RESERVA_ID")
    private Integer estado;

    @Column(name = "FECHA_RESERVA")
    private Date fechaReserva;

    @Column(name = "ES_SOBRECUPO")
    private Integer sobrecupo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAgenda() {
        return agenda;
    }

    public void setAgenda(Integer agenda) {
        this.agenda = agenda;
    }

    public Integer getPaciente() {
        return paciente;
    }

    public void setPaciente(Integer paciente) {
        this.paciente = paciente;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Integer getSobrecupo() {
        return sobrecupo;
    }

    public void setSobrecupo(Integer sobrecupo) {
        this.sobrecupo = sobrecupo;
    }
}
