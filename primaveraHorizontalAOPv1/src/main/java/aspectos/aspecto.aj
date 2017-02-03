package aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.time.LocalTime;

/**
 * Created by Patata kawaii on 02/02/2017.
 */

@Aspect
public aspect aspecto {

    @Before("execution(public void Negocio.LogicaNegocio.ant(String))")
    public void horaEjecucion(){
        System.out.println("pene");
        System.out.println(LocalTime.now());
    }
}
