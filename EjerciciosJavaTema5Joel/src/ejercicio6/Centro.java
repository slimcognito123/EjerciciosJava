package ejercicio6;

import java.util.ArrayList;

public class Centro {

	private ArrayList<Persona> lista;
	
	public Centro(ArrayList<Persona> lista){
		this.lista = lista;
	}

	public ArrayList<Persona> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Persona> lista) {
		this.lista = lista;
	}
	
	public void imprimirSalarioEmpleados(){
		for (Persona persona : lista) {
			if(persona instanceof Empleado){
				((Empleado) persona).imprimirSalario();;
			}
		}
	}
	
	public void imprimirDatosPersonas(){
		for (Persona persona : lista) {
			persona.imprimirInfo();
		}
	}
	
}
