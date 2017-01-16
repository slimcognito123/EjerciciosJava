package Modelo.Personas;

import Beans.Persona;
import Modelo.Personas.PersonaDAO;

import java.util.ArrayList;


public class PersonaJPA implements PersonaDAO {
    @Override
    public Boolean borrarPersona(int id, String usuario) {
        return null;
    }

    @Override
    public void modificarPersona(Persona persona, String user) {

    }

    @Override
    public ArrayList<Persona> recuperarTodasLasPersonas(String mes, String usuario) {
        return null;
    }

    @Override
    public Persona recuperarPersona(int id) {
        return null;
    }

    @Override
    public void guardarPersona(Persona persona, String user) {

    }
}
