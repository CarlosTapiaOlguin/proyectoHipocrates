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
@Table(name = "AGENDA")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Agenda implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQ_AGENDA")
    @SequenceGenerator(name = "SEQ_AGENDA", sequenceName = "SEQ_AGENDA", allocationSize = 5)
    @Column(name = "ID")
    private Integer id;


    @OneToOne
    @JoinColumn(name = "TURNO_ID")
    private Turno turno;


    @Column(name = "DIA")
    private Date fecha;


    @OneToOne
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;


    @Column(name = "ES_SOBRECUPO")
    private Integer esSobrecupo;


    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;

    @Column(name = "ESTADO_AGENDA_ID")
    private Integer estado;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Integer getEsSobrecupo() {
        return esSobrecupo;
    }

    public void setEsSobrecupo(Integer esSobrecupo) {
        this.esSobrecupo = esSobrecupo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
