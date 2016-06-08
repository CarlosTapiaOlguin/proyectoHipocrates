package cl.duoc.agendamedica.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: kristhian.marquez
 * Fecha:  06-05-2015.
 * Proyecto: AplicacionWebSpingJquery
 */
@XmlRootElement
@Entity
@Table(name = "ECRMBGEC")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Cliente implements Serializable {

    @Id
    @Column(name = "RUT_CLIENTE")
    private int rut;
    @Column(name = "NOM_CLIENTE")
    private String nombre;
    @Column(name = "APE_PAT_BGC")
    private String apellidos;
    @Column(name = "COD_TIPO_CLIENTE")
    private int tipoCliente;
    @Column(name = "NUM_LINEAS_OCU")
    private int cantidadLineas;


    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getCantidadLineas() {
        return cantidadLineas;
    }

    public void setCantidadLineas(int cantidadLineas) {
        this.cantidadLineas = cantidadLineas;
    }
}
