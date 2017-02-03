import Negocio.InterfaceLogicaNegocio;
import Negocio.LogicaNegocio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Patata kawaii on 02/02/2017.
 */
public class Tester {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});
        InterfaceLogicaNegocio logicaNegocio = (InterfaceLogicaNegocio) applicationContext.getBean("logicaNegocio");
        logicaNegocio.ant("holo");
        logicaNegocio.foo("adio");

    }
}
