package cl.duoc.agendamedica.modelo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Administrador on 26-05-2016.
 */
@XmlRootElement
@Entity
@Table(name = "USUARIO")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Usuario {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "NOMBRE")
    private String nombreCompleto;

    @Column(name = "PASS")
    private String password;

    @Column(name = "CORREO")
    private String correo;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
