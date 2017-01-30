package main;

import beans.Direccion;
import beans.Persona;
import ejemplo.Estudiante;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring-config.xml"});
        Estudiante persona=(Estudiante) applicationContext.getBean("estudiante");
        persona.setNombre("Max");
        System.out.println(persona);
    }
}
