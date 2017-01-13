package Modelo.Personas;


import Beans.Persona;

import java.util.ArrayList;

public interface PersonaDAO {
    boolean guardarPersona(Persona persona);

   // Persona recuperarPersona(int id,String usuario);

    ArrayList<Persona> recuperarTodasLasPersonas();

    Boolean borrarPersona(int id,String usuario);

    void modificarPersona(Persona persona, String user);

    ArrayList<Persona> recuperarTodasLasPersonas(String usuario);

    ArrayList<Persona> recuperarTodasLasPersonas(String mes, String usuario);


    Persona recuperarPersona(int id);

    void guardarPersona(Persona persona, String user);
}
