package cl.duoc.agendamedica.util;


import org.apache.commons.codec.binary.Base64;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * User: kristhian.marquez
 * Fecha:  06-05-2015.
 * Proyecto: AplicacionWebSpingJquery
 */
public class Utils {
    public static final String ESPECIALIDAD_LABORATORIO = "1";
    public static final String ESPECIALIDAD_MEDICA = "0";
    public static final Integer RESERVA_RESERVADO = 3;
    public static final Integer RESERVA_ASISTE = 4;
    public static final Integer RESERVA_NO_SOBRECUPO = 0;
    public static final Integer ISAPRE_FONASA = 21;
    public static final Integer AGENDA_DISPONIBLE = 1;
    public static final Integer AGENDA_RESERVADO = 3;


    public static Date dateFromString(String date) throws ParseException {
        System.out.println("dateFromString :" + date);
        SimpleDateFormat format = new SimpleDateFormat("MMddyyyy");
        java.util.Date parsed = format.parse(date);
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        System.out.println("dateFromString :" + sql);
        return sql;
    }
    public static Date getCurrentDate() {
        return  new java.sql.Date(Calendar.getInstance().getTime().getTime());
    }
}
