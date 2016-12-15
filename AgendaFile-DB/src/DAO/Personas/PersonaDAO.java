package DAO.Personas;


import Beans.Persona;

import java.util.ArrayList;

public interface PersonaDAO {
    boolean guardarPersona(Persona persona);

    Persona recuperarPersona(String dni);

    ArrayList<Persona> recuperarTodasLasPersonas();

    Boolean borrarPersona(String dni);

    Persona modificarPersona(Persona persona);

}
