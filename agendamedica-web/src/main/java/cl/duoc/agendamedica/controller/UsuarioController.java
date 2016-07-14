package cl.duoc.agendamedica.controller;

import cl.duoc.agendamedica.dao.UsuarioDAO;
import cl.duoc.agendamedica.exceptions.MessageException;
import cl.duoc.agendamedica.modelo.Paciente;
import cl.duoc.agendamedica.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Proyecto: agendamedica
 */
@RestController
@RequestMapping("/usuariocontroller")
public class UsuarioController {


    @Autowired
    private UsuarioDAO usuarioDAO;


    @Transactional
    @RequestMapping(value = "/registro", method = RequestMethod.POST, headers = "Accept=application/json")
    public void registrarUsuario(@RequestBody Paciente paciente, HttpServletResponse response) throws IOException {
        try {
            usuarioDAO.guardarUsuario(paciente);
        }catch (Exception e){
            response.sendError(response.SC_BAD_REQUEST, e.getMessage());
        }
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Paciente loginUsuario(@RequestBody Usuario usuario, HttpServletResponse response) throws IOException {
        Paciente usuario_rtn = null;
        try {
            usuario_rtn =  usuarioDAO.findUsuarioByRutAndPassword(usuario);
        } catch (MessageException e) {
            response.sendError(response.SC_BAD_REQUEST, e.getMessage());
        }
        return usuario_rtn;
    }

}
