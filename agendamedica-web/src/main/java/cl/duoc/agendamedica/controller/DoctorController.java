package cl.duoc.agendamedica.controller;

import cl.duoc.agendamedica.dao.DoctorDAO;
import cl.duoc.agendamedica.modelo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Proyecto: agendamedica
 */
@RestController
@RequestMapping("/doctorcontroller")
public class DoctorController {


    @Autowired
    private DoctorDAO doctorDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Doctor> getAll(HttpServletResponse response) {
        return doctorDAO.getAllDoctors();
    }



}
