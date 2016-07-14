package cl.duoc.agendamedica.dao;

import cl.duoc.agendamedica.modelo.Especialidad;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Proyecto: agendamedica
 */
@Repository
public class EspecialidadesDAO extends agendamedicaDAO {

    public List<Especialidad> getEspecialidades(String laboratorio) {
        Query query = em.createQuery("Select e from Especialidad e where e.laboratorio = :lab");
        query.setParameter("lab", laboratorio);
        return query.getResultList();
    }


}
