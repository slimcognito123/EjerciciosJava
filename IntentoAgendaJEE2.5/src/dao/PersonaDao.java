package dao;

import java.util.ArrayList;

import beans.Persona;

public interface PersonaDao {

	public boolean guardarPersona(Persona p);
	public Persona recuperarPersona(int id);
	public ArrayList<Persona> recuperarContactosDe(String nombreUsuario);
	public boolean borrarPersona(int id);
	public boolean modificarPersona(Persona persona);
}
