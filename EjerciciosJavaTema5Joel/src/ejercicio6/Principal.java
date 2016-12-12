package ejercicio6;

import java.util.ArrayList;

public class Principal {
 
	public static void main(String[] args) {
		Persona estudiante = new Estudiante("Luis", "Garc�a", "A001", "soltero", "Programaci�n Web");
		Persona estudiante2 = new Estudiante("Mario", "L�pez", "A002", "soltero", "Programaci�n Web");
		Persona profesor = new Profesor("Ra�l", "P�rez", "P001", "casado", 2005, "M105", "Matem�ticas");
		Persona profesor2 = new Profesor("Javier", "Hern�ndez", "P002", "soltero", 1999, "L100", "Lenguajes");
		Persona personal = new PersonalServicio("Paco", "Fern�ndez", "PS001", "casado", 1995, "B100", "Biblioteca");
		Persona personal2 = new PersonalServicio("Julio", "Franco", "PS002", "soltero", 1999, "D102", "Decanato");
		
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add(estudiante);
		lista.add(estudiante2);
		lista.add(profesor);
		lista.add(profesor2);
		lista.add(personal);
		lista.add(personal2);
		Centro centro = new Centro(lista);
		
		//INFORMACI�N DE TODOS LOS INDIVIDUOS
		System.out.println("INFORMACI�N PERSONAS:");
		centro.imprimirDatosPersonas();
		
		System.out.println("--------------------------------------------------------------");
        
		//SALARIOS DE TODOS LOS EMPLEADOS DEL CENTRO
		System.out.println("SALARIOS DE EMPLEADOS:");
        centro.imprimirSalarioEmpleados();
        
        System.out.println("--------------------------------------------------------------");
		
        //PROBANDO OTROS M�TODOS
        System.out.println("ALGUNOS CAMBIOS:");
        lista.get(0).cambiarEstado("casado");
        ((Empleado)lista.get(2)).reasignarDespacho("M100");
        ((Estudiante)lista.get(1)).matricularCurso("Programaci�n Java");
        ((Profesor)lista.get(3)).cambiarDepartamento("Arquitectura");
        ((PersonalServicio)lista.get(4)).cambiarSeccion("Secretar�a");
        centro.imprimirDatosPersonas();
		
      
	}
}
