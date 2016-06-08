package cl.duoc.agendamedica.controller;


import cl.duoc.agendamedica.dto.LoginDTO;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by Administrador on 06-06-2016.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    /**
     * retorna un token a partir de un login.
     * POSICIONES PAYLOAD : {CORREO};{TIMESTAM GENERACION}:{TIMESTAMP CADUCIDAD}
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
    public String getToken(@RequestBody LoginDTO loginDTO)  {

        if (loginDTO.getCorreo().equals("carlostapiaolguin1@gmail.com")) {
            return "ok";
        }
        return "error";
    }




}
