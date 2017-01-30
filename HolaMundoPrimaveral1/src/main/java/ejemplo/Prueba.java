package ejemplo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba {
    public static void main(String[] args){
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Estudiante estudiante = (Estudiante) applicationContext.getBean("estudiante");
        System.out.println("\033[36m"+estudiante.getNombre());
        Estudiante estudiante1 = (Estudiante) applicationContext.getBean("estudiante1");
        Estudiante estudiante2 = (Estudiante) applicationContext.getBean("estudiante2");
        Estudiante estudiante4 = (Estudiante) applicationContext.getBean("estudiante4");

        System.out.println("\033[34m"+estudiante1.getNombre()+" "+estudiante1.getEdad()+ " NUMERO DE AMIJOS "+ estudiante1.numeroAmigos());
        System.out.println("\033[37m"+estudiante2.getNombre()+" "+estudiante2.getEdad());
        System.out.println("\033[35m"+estudiante4.getNombre());
        applicationContext.registerShutdownHook();
    }
}
