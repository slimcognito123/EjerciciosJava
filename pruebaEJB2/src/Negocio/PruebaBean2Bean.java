package Negocio;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Created by curso mañana on 18/01/2017.
 */
@Stateless(name = "PruebaBean2EJB")
@LocalBean
public class PruebaBean2Bean implements pruebaBean2Remote, pruebaBean2Local{
    @EJB
    private PruebaBean primer;

    public PruebaBean2Bean() {
    }
    public String despedir(String nombre){
        String saludo=primer.saludo(nombre);
        saludo+="\n Adios ha sido un placer";
        return saludo;
    }

    @PostConstruct
    public  void  metodoCreacion(){
        System.out.println("creando");
    }

    @PreDestroy
    public void metodoDestruccion(){
        System.out.println("voy a explotar");
    }
}
