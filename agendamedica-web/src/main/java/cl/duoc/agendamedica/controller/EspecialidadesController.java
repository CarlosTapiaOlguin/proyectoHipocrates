package cl.duoc.agendamedica.controller;

import cl.duoc.agendamedica.dao.EspecialidadesDAO;
import cl.duoc.agendamedica.modelo.Especialidad;
import cl.duoc.agendamedica.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Proyecto: agendamedica
 */
@RestController
@RequestMapping("/especialidadescontroller")
public class EspecialidadesController {


    @Autowired
    private EspecialidadesDAO especialidadesDAO;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/laboratorio/all", method = RequestMethod.GET, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Especialidad> getEspecialidadesLaboratorio() {
        return especialidadesDAO.getEspecialidades(Utils.ESPECIALIDAD_LABORATORIO);
    }


    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/medicas/all", method = RequestMethod.GET, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Especialidad> getEspecialidadesMedicas() {
        return especialidadesDAO.getEspecialidades(Utils.ESPECIALIDAD_MEDICA);
    }


}
