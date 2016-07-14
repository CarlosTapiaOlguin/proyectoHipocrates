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
@Table(name = "RESERVAS")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReservaInfo implements Serializable{

    @Id
    @GeneratedValue(generator="SEQ_RESERVAS")
    @SequenceGenerator(name="SEQ_RESERVAS",sequenceName="SEQ_RESERVAS", allocationSize=1)
    @Column(name = "ID")
    private int id;

    @OneToOne
    @JoinColumn(name = "AGENDA_ID")
    private Agenda agenda;

    @OneToOne
    @JoinColumn(name = "PACIENTE_ID")
    private Paciente paciente;

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

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
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
