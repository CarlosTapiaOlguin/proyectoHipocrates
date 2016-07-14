package cl.duoc.agendamedica.dao;

import cl.duoc.agendamedica.modelo.Prevision;
import cl.duoc.agendamedica.modelo.Region;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Proyecto: agendamedica
 */
@Repository
public class PrevisionDAO extends agendamedicaDAO {

  public List<Prevision> getAllPrevisions() {
      Query query = em.createQuery("Select c from Prevision c ");
      return query.getResultList();
  }



}
