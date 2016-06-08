package cl.duoc.agendamedica.dao;

import cl.duoc.agendamedica.modelo.Doctor;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Proyecto: agendamedica
 */
@Repository
public class DoctorDAO extends agendamedicaDAO {

  public List<Doctor> getAllDoctors() {
      Query query = em.createQuery("Select d from Doctor d ");
      query.setFirstResult(0);
      query.setMaxResults(10);
      return query.getResultList();
  }



}
