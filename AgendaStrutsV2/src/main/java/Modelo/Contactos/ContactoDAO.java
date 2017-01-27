package Modelo.Contactos;


import Beans.Contacto;

import java.util.ArrayList;

public interface ContactoDAO {

    Boolean borrarPersona(int id);

    void modificarPersona(Contacto contacto);

    ArrayList<Contacto> recuperarTodasLasPersonas(String mes, String usuario);


    Contacto recuperarPersona(int id);

    void guardarPersona(Contacto contacto);

    ArrayList<Contacto> recuperarTodasLasPersonas(String usuario);

}
