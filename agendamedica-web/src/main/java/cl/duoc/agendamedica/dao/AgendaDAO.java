package cl.duoc.agendamedica.dao;

import cl.duoc.agendamedica.exceptions.MessageException;
import cl.duoc.agendamedica.modelo.Agenda;
import cl.duoc.agendamedica.modelo.Reserva;
import cl.duoc.agendamedica.modelo.ReservaInfo;
import cl.duoc.agendamedica.util.Utils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

/**
 * Proyecto: agendamedica
 */
@Repository
public class AgendaDAO extends agendamedicaDAO {


    public List<Agenda> findAgendaByDoctorByFecha(Integer idDoctor, String fecha) throws MessageException {
        System.out.println("findAgendaByDoctorByFecha : " + idDoctor + " " + fecha);
        Query query = em.createQuery("Select a from Agenda a WHERE a.doctor.usuario.id = :doctorId and a.fecha= :fecha and a.estado = :estado");
        query.setParameter("doctorId", idDoctor);
        try {
            query.setParameter("fecha", Utils.dateFromString(fecha));
        } catch (ParseException e) {
            throw new MessageException("El formado de la fecha es incorrecto " + fecha);
        }
        query.setParameter("estado", Utils.AGENDA_DISPONIBLE);
        return query.getResultList();
    }

    @Transactional
    public void reservarAgenda(Integer idAgenda, Integer idPaciente) throws MessageException {
        Reserva reserva = new Reserva();
        reserva.setAgenda(idAgenda);
        reserva.setEstado(Utils.RESERVA_RESERVADO);
        reserva.setFechaReserva(Utils.getCurrentDate());
        reserva.setPaciente(idPaciente);
        reserva.setSobrecupo(Utils.RESERVA_NO_SOBRECUPO);
        Agenda agenda = getAgendaById(idAgenda);
        agenda.setEstado(3);
        em.merge(reserva);
        em.merge(agenda);
        em.flush();
    }


    public Agenda getAgendaById(Integer idAgenda) {
        System.out.println(idAgenda);
        Query query = em.createQuery("Select a from Agenda a WHERE a.id = :idAgenda");
        query.setParameter("idAgenda", idAgenda);
        return (Agenda) query.getSingleResult();
    }

    @Transactional
    public void anularReserva(Integer idReserva) {
        System.out.println(idReserva);
        Query query = em.createQuery("update Reserva r set estado = 2 WHERE r.id = :idReserva");
        query.setParameter("idReserva", idReserva);
        query.executeUpdate();

        query = em.createNativeQuery("select AGENDA_ID from RESERVAS WHERE ID =" + idReserva);
        BigDecimal idAgenda = (BigDecimal) query.getSingleResult();

        query = em.createQuery("update Agenda a set estado = 1 WHERE a.id = :idAgenda");
        query.setParameter("idAgenda", idAgenda);
        query.executeUpdate();
    }


    public List<ReservaInfo> getAllReservaByPaciente(Integer idPaciente, Integer estado) {
        System.out.println("getAllReservaByPaciente : " + idPaciente);
        Query query = em.createQuery("Select r from ReservaInfo r WHERE r.paciente.id = :idPaciente and r.estado = :estado ORDER BY r.agenda.fecha,r.agenda.turno.horaInicio ASC");
        query.setParameter("idPaciente", idPaciente);
        query.setParameter("estado", estado);
        return query.getResultList();
    }

}
