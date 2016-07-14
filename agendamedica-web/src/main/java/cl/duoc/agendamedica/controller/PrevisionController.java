package cl.duoc.agendamedica.controller;

import cl.duoc.agendamedica.dao.PrevisionDAO;
import cl.duoc.agendamedica.dao.RegionDAO;
import cl.duoc.agendamedica.modelo.Prevision;
import cl.duoc.agendamedica.modelo.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Proyecto: agendamedica
 */
@RestController
@RequestMapping("/previsioncontroller")
public class PrevisionController {


    @Autowired
    private PrevisionDAO previsionDAO;


    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Prevision> getRegiones(HttpServletResponse response) {
        return previsionDAO.getAllPrevisions();
    }



}

