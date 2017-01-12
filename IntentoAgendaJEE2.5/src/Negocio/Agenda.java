package Negocio;

import java.util.ArrayList;
import beans.Persona;
import dao.PersonaDao;
import dao.PersonaDAOJdbc;

public class Agenda {

	private PersonaDao persona;
	
	public Agenda(){
		persona = new PersonaDAOJdbc();
	}
	
	public String aniadirPersona(Persona p){
		boolean ok = persona.guardarPersona(p);
		if(ok == true)
			return "Persona guardada correctamente";
		else
			return "Error al guardar persona";
	}
	
	public String borrarPersonaPorId(int id){
		boolean ok = persona.borrarPersona(id);
		if(ok == true)
			return "Persona borrada correctamente";
		else
			return "Error al borrar persona";
	}
	
	public Persona buscarPersonaPorId(int id){
		return persona.recuperarPersona(id);
	}
	
	public String modificarPersona(Persona p){
		boolean ok = persona.modificarPersona(p);
		if(ok == true)
			return "Persona actualizada";
		else
			return "Error al modificar persona";
	}
	
	public ArrayList<Persona> recuperarAgendaDe(String nombreUsuario){
		return persona.recuperarContactosDe(nombreUsuario);
	}
	/*
	public ArrayList<Persona> recuperarCumplenEnDe(int mes, String usuario){
		ArrayList<Persona> contactos = persona.recuperarContactosDe(nombreUsuario);
		
	}
*/
}
