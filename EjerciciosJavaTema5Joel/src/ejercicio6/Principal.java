package ejercicio6;

import java.util.ArrayList;

public class Principal {
 
	public static void main(String[] args) {
		Persona estudiante = new Estudiante("Luis", "García", "A001", "soltero", "Programación Web");
		Persona estudiante2 = new Estudiante("Mario", "López", "A002", "soltero", "Programación Web");
		Persona profesor = new Profesor("Raúl", "Pérez", "P001", "casado", 2005, "M105", "Matemáticas");
		Persona profesor2 = new Profesor("Javier", "Hernández", "P002", "soltero", 1999, "L100", "Lenguajes");
		Persona personal = new PersonalServicio("Paco", "Fernández", "PS001", "casado", 1995, "B100", "Biblioteca");
		Persona personal2 = new PersonalServicio("Julio", "Franco", "PS002", "soltero", 1999, "D102", "Decanato");
		
		ArrayList<Persona> lista = new ArrayList<Persona>();
		lista.add(estudiante);
		lista.add(estudiante2);
		lista.add(profesor);
		lista.add(profesor2);
		lista.add(personal);
		lista.add(personal2);
		Centro centro = new Centro(lista);
		
		//INFORMACIÓN DE TODOS LOS INDIVIDUOS
		System.out.println("INFORMACIÓN PERSONAS:");
		centro.imprimirDatosPersonas();
		
		System.out.println("--------------------------------------------------------------");
        
		//SALARIOS DE TODOS LOS EMPLEADOS DEL CENTRO
		System.out.println("SALARIOS DE EMPLEADOS:");
        centro.imprimirSalarioEmpleados();
        
        System.out.println("--------------------------------------------------------------");
		
        //PROBANDO OTROS MÉTODOS
        System.out.println("ALGUNOS CAMBIOS:");
        lista.get(0).cambiarEstado("casado");
        ((Empleado)lista.get(2)).reasignarDespacho("M100");
        ((Estudiante)lista.get(1)).matricularCurso("Programación Java");
        ((Profesor)lista.get(3)).cambiarDepartamento("Arquitectura");
        ((PersonalServicio)lista.get(4)).cambiarSeccion("Secretaría");
        centro.imprimirDatosPersonas();
		
      
	}
}
