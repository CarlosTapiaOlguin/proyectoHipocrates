package cl.duoc.agendamedica.dao;

import cl.duoc.agendamedica.modelo.Region;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Proyecto: agendamedica
 */
@Repository
public class RegionDAO extends agendamedicaDAO {

  public List<Region> getAllRegiones() {
      Query query = em.createQuery("Select c from Region c ");
      return query.getResultList();
  }



}
