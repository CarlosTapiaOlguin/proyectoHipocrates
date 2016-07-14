package cl.duoc.agendamedica.controller;

import cl.duoc.agendamedica.dao.AgendaDAO;
import cl.duoc.agendamedica.exceptions.MessageException;
import cl.duoc.agendamedica.modelo.Agenda;
import cl.duoc.agendamedica.modelo.Reserva;
import cl.duoc.agendamedica.modelo.ReservaInfo;
import cl.duoc.agendamedica.modelo.Respuesta;
import cl.duoc.agendamedica.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 12-07-2016.
 */
@RestController
@RequestMapping("/reservacontroller")
public class ReservaController {


    @Autowired
    private AgendaDAO agendaDAO;

    @RequestMapping(value = "disponibilidad/{idMedico}/{fecha}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Agenda> obtenerDisponibilidadMedico(@PathVariable Integer idMedico, @PathVariable String fecha, HttpServletResponse response) throws IOException {
        List<Agenda> horasDiponibles = null;
        try {
            horasDiponibles = agendaDAO.findAgendaByDoctorByFecha(idMedico, fecha);
        } catch (MessageException e) {
            response.sendError(response.SC_BAD_REQUEST, e.getMessage());
        } catch (NoResultException e) {
            response.sendError(response.SC_BAD_REQUEST, "No se a encontrado disponibilidad");
        }
        return horasDiponibles;
    }

    @RequestMapping(value = "reservar/{idAgenda}/{idUsuario}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Respuesta reservar(@PathVariable Integer idAgenda, @PathVariable Integer idUsuario, HttpServletResponse response) throws IOException {
        System.out.println("reservar : " + idAgenda + " " + idUsuario);
        Respuesta respuesta = new Respuesta();
        try {
            agendaDAO.reservarAgenda(idAgenda, idUsuario);
            respuesta.setMensaje("Reserva realizada con exito.");
        } catch (MessageException e) {
            response.sendError(response.SC_BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(response.SC_BAD_REQUEST, "Error al realizar la reserva.");
        }
        return respuesta;
    }

    @RequestMapping(value = "pendientes/{idPaciente}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<ReservaInfo> reservasPendientes(@PathVariable Integer idPaciente, HttpServletResponse response) throws IOException {
        List<ReservaInfo> reservaInfoList = new ArrayList<ReservaInfo>();
        try {
            reservaInfoList = agendaDAO.getAllReservaByPaciente(idPaciente, Utils.RESERVA_RESERVADO);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            response.sendError(response.SC_BAD_REQUEST, "Error al obtener las reservas.");
        }
        return reservaInfoList;
    }

    @RequestMapping(value = "historial/{idPaciente}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<ReservaInfo> reservasHistorial(@PathVariable Integer idPaciente, HttpServletResponse response) throws IOException {
        List<ReservaInfo> reservaInfoList = new ArrayList<ReservaInfo>();
        try {
            reservaInfoList = agendaDAO.getAllReservaByPaciente(idPaciente, Utils.RESERVA_ASISTE);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            response.sendError(response.SC_BAD_REQUEST, "Error al obtener las reservas.");
        }
        return reservaInfoList;
    }

    @RequestMapping(value = "anular/{idReserva}", method = RequestMethod.GET, headers = "Accept=application/json")
    public void anularReserva(@PathVariable Integer idReserva, HttpServletResponse response) throws IOException {
        try {
            agendaDAO.anularReserva(idReserva);
        }catch (Exception e) {
            e.printStackTrace();
            response.sendError(response.SC_BAD_REQUEST, "Error al anular la reserva.");
        }
    }


}