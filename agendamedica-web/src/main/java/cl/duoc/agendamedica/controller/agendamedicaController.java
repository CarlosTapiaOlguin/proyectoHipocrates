package cl.duoc.agendamedica.controller;

import cl.duoc.agendamedica.dao.ClienteDAO;
import cl.duoc.agendamedica.modelo.Cliente;
import cl.duoc.agendamedica.modelo.Respuesta;
import cl.duoc.agendamedica.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Proyecto: agendamedica
 */
@RestController
@RequestMapping("/clientes")
public class agendamedicaController {


    @Autowired
    private ClienteDAO clienteDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Cliente> getClientes(HttpServletResponse response) {
        SpringUtils.setHeader(response);
        return clienteDAO.getClientes();
    }


    @RequestMapping(value = "/{rut}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Cliente> getCliente(@PathVariable int rut, HttpServletResponse response) {
        SpringUtils.setHeader(response);
        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cli = clienteDAO.getCliente(rut);
        if (cli != null) {
            clientes.add(cli);
        }
        return clientes;
    }

    @Transactional
    @RequestMapping(value = "/prueba2", method = RequestMethod.POST, headers = "Accept=application/json")
    public
    @ResponseBody
    Respuesta updateCliente(@RequestBody Cliente cliente, HttpServletResponse response) throws Exception {
        SpringUtils.setHeader(response);
        Respuesta resp = new Respuesta();
        if (cliente.getCantidadLineas() > 100) {
            resp.setError(true);
            resp.setMensaje("El maximo de lineas es 100.");
        } else {
            clienteDAO.updateCliente(cliente);
        }

        return resp;
    }


    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
}
