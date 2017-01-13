package Modelo.Personas;


import Beans.Persona;

import java.util.ArrayList;

public interface PersonaDAO {

    Boolean borrarPersona(int id,String usuario);

    void modificarPersona(Persona persona, String user);


    ArrayList<Persona> recuperarTodasLasPersonas(String mes, String usuario);


    Persona recuperarPersona(int id);

    void guardarPersona(Persona persona, String user);
}
