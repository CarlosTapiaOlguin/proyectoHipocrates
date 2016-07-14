package cl.duoc.agendamedica.modelo;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

/**
 * Created by Administrador on 26-05-2016.
 */
@XmlRootElement
@Entity
@Table(name = "USUARIOS")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(generator="SEQ_USUARIOS")
    @SequenceGenerator(name="SEQ_USUARIOS",sequenceName="SEQ_USUARIOS", allocationSize=1)
    @Column(name = "ID")
    private int id;

    @Column(name = "NOMBRES")
    private String nombres;

    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "EMAIL")
    private String correo;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "RUT")
    private String rut;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "COMUNA_ID")
    private int comuna;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }
}
