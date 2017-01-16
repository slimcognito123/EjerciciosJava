package Modelo.Personas;


import Beans.Contacto;

import java.util.ArrayList;

public interface PersonaDAO {

    Boolean borrarPersona(int id, String usuario);

    void modificarPersona(Contacto contacto, String user);


    ArrayList<Contacto> recuperarTodasLasPersonas(String mes, String usuario);


    Contacto recuperarPersona(int id);

    void guardarPersona(Contacto contacto, String user);
}
