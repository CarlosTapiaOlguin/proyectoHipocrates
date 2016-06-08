package cl.duoc.agendamedica.dto;

import java.io.Serializable;

/**
 * Created by Administrador on 06-06-2016.
 */
public class LoginDTO implements Serializable{
    private String correo;
    private String password;
    private boolean recordar;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRecordar() {
        return recordar;
    }

    public void setRecordar(boolean recordar) {
        this.recordar = recordar;
    }
}
