package cl.duoc.agendamedica.dao;

import cl.duoc.agendamedica.exceptions.MessageException;
import cl.duoc.agendamedica.modelo.Paciente;
import cl.duoc.agendamedica.modelo.Usuario;
import cl.duoc.agendamedica.util.Utils;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Proyecto: agendamedica
 */
@Repository
public class UsuarioDAO extends agendamedicaDAO {

    public List<Usuario> getAllUsuarios() {
        Query query = em.createQuery("Select u from Usuario u ");
        return query.getResultList();
    }


    public List<Usuario> findUsuarioByRut(String rut) {
        Query query = em.createQuery("Select u from Usuario u WHERE u.usuario = :rut");
        query.setParameter("rut", rut);

        return query.getResultList();
    }

    public Paciente findUsuarioByRutAndPassword(Usuario usuario) throws MessageException {
        Query query = em.createQuery("Select u from Paciente u WHERE u.usuario.rut = :rut");
        query.setParameter("rut", usuario.getRut());
        List<Paciente> pacienteList = query.getResultList();
        if (!pacienteList.isEmpty()){
            if (pacienteList.get(0).getUsuario().getPassword().equals(usuario.getPassword())){
                return pacienteList.get(0);
            }else {
                throw new MessageException("Contraseña incorrecta");
            }
        }else {
            throw new MessageException("El rut no se encuentra registrado");
        }
    }

    public void guardarUsuario(Paciente paciente) {
        em.merge(paciente);
        em.flush();
    }

}
