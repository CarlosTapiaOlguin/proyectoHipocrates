package cl.duoc.agendamedica.util;

import javax.servlet.http.HttpServletResponse;

/**
 * User: kristhian.marquez
 * Fecha:  06-05-2015.
 * Proyecto: AplicacionWebSpingJquery
 */
public class SpringUtils {

    public static HttpServletResponse setHeader(HttpServletResponse r){
        r.setHeader("Access-Control-Allow-Origin", "*");
        r.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        r.setHeader("Access-Control-Max-Age", "3600");
        r.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        return r;
    }

}
