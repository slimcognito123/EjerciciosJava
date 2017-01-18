package Negocio;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by curso mañana on 18/01/2017.
 */
@Stateless(name = "PruebaEJB")
@LocalBean
public class PruebaBean implements  PrimerEJBRemote, PrimerEJBLocal{
    public PruebaBean() {
    }

    public String saludo(String nombre) {
        if(nombre==null){
            return "saludos desconocido";
        }else return "saludos "+nombre ;
    }
}
