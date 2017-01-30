package main;

import beans.Persiana;
import beans.PersonaMejorada;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LanzadorSpring {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"judias2.xml"});
        PersonaMejorada persona = (PersonaMejorada) applicationContext.getBean("MadMax");
        PersonaMejorada persona2 = (PersonaMejorada) applicationContext.getBean("MadMax");
        System.out.println("\033[35m");
        System.out.println(persona);
        System.out.println(persona2);
        Persiana persiana = (Persiana) applicationContext.getBean("persiana");
        System.out.println("\033[38m"+persiana);
    }
}
