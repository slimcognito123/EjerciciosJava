package Modelo.Business;

import Beans.Contacto;
import Modelo.DAO.Contactos.ContactoDAO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "agendaBusiness")
public class AgendaBusiness {
    @Autowired
    @Qualifier("contactoDAO")
    private ContactoDAO contactoDao;

    public void modificarPersona(Contacto contacto){
        contactoDao.modificarPersona(contacto);
    }

    public ArrayList<Contacto> recuperarAgendaPorMes(String mes, String usuario) {
        return contactoDao.recuperarTodasLasPersonas(mes,usuario);
    }

    public void eliminarPersonaid(ObjectId id) {
        contactoDao.borrarPersona(id);
    }

    public Contacto recuperarPersona(ObjectId id) {
        return contactoDao.recuperarPersona(id);
    }

    public void anadirPersonaOnline(Contacto contacto) {
        contactoDao.guardarPersona(contacto);
    }

    public ArrayList<Contacto> recuperarAgendaCompleta(String usuario) {
        return contactoDao.recuperarTodasLasPersonas(usuario);
    }
}
