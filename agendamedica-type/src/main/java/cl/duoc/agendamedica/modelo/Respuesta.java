package cl.duoc.agendamedica.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * User: kristhian.marquez
 * Fecha:  26-06-2015.
 * Proyecto: AplicacionWebSpingJquery
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Respuesta implements Serializable{

    private boolean error;
    private String mensaje;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
