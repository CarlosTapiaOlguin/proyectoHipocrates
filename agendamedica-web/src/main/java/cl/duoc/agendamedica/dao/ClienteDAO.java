package cl.duoc.agendamedica.dao;

import cl.duoc.agendamedica.modelo.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Proyecto: agendamedica
 */
@Repository
public class ClienteDAO extends agendamedicaDAO {

  public List<Cliente> getClientes() {
      Query query = em.createQuery("Select c from Cliente c ");
      query.setFirstResult(0);
      query.setMaxResults(10);
      return query.getResultList();
  }

    public Cliente getCliente(int rut) {
        return em.find(Cliente.class, rut);
    }
    @Transactional
    public void updateCliente(Cliente cliente) {
        if (cliente.getRut() == 10016539){
            throw new RuntimeException("prueba de error");
        }
        em.merge(cliente);
        em.flush();
    }


}
