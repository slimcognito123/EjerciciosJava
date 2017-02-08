package Modelo.DAO.Contactos;


import Beans.Contacto;
import Beans.Usuario;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository("DAO")
public interface ContactoDAO {

    Boolean borrarPersona(ObjectId _id);

    void modificarPersona(Contacto contacto);


    ArrayList<Contacto> recuperarTodasLasPersonas(String mes, String usuario);

    ArrayList<ObjectId> recuperarTodasLasId(Usuario usuario);

    Contacto recuperarPersona(ObjectId _id);

    void guardarPersona(Contacto contacto);

    ArrayList<Contacto> recuperarTodasLasPersonas(String usuario);
}
