package cl.duoc.agendamedica.controller;

import cl.duoc.agendamedica.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Proyecto: agendamedica
 */
@RestController
@RequestMapping("/medicocontroller")
public class MedicoController {


    @Autowired
    private UsuarioDAO usuarioDAO;

/*
    @Transactional
    @RequestMapping(value = "/especialidad/{idEspecialidad}", method = RequestMethod.POST, headers = "Accept=application/json")
    public void registrarUsuario(@PathVariable Integer idEspecialidad, HttpServletResponse response) throws IOException {
        try {
            usuarioDAO.guardarUsuario(usuario);
        }catch (Exception e){
            response.sendError(response.SC_BAD_REQUEST, e.getMessage());
        }
    }*/

}
