package Negocio;

import org.springframework.stereotype.Component;

/**
 * Created by Patata kawaii on 02/02/2017.
 */

@Component
public class LogicaNegocio implements InterfaceLogicaNegocio {

    @Override
    public void foo(String p1) {
        System.out.println("*******************");
        System.out.println("Dentro de LogicaNegocio.foo()");
        System.out.println("*******************");
    }

    @Override
    public void ant(String p2) {
        System.out.println("*******************");
        System.out.println("Dentro de LogicaNegocio.ant()");
        System.out.println("*******************");
    }
    public String cadena(String p){
        return p;
    }

}