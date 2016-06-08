package cl.duoc.agendamedica.dao;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Proyecto: agendamedica
 */
@Repository
public class agendamedicaDAO {

    @PersistenceContext(type = PersistenceContextType.TRANSACTION,
            unitName = "Transaccion")
    protected EntityManager em;



    public EntityManager getEm() {
        return em;
    }

    /**
     * para ser usado por los test
     * @return
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
