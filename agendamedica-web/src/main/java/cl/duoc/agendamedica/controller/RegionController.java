package cl.duoc.agendamedica.controller;

import cl.duoc.agendamedica.dao.RegionDAO;
import cl.duoc.agendamedica.modelo.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Proyecto: agendamedica
 */
@RestController
@RequestMapping("/regioncontroller")
public class RegionController {


    @Autowired
    private RegionDAO regionDAO;


    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Region> getRegiones(HttpServletResponse response) {
        return regionDAO.getAllRegiones();
    }



}

