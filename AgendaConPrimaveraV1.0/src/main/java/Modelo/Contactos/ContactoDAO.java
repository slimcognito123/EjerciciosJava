package Modelo.Contactos;


import Beans.Contacto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public interface ContactoDAO {

    Boolean borrarPersona(int id);

    void modificarPersona(Contacto contacto);


    ArrayList<Contacto> recuperarTodasLasPersonas(String mes, String usuario);


    Contacto recuperarPersona(int id);

    void guardarPersona(Contacto contacto);

    ArrayList<Contacto> recuperarTodasLasPersonas(String usuario);
}
