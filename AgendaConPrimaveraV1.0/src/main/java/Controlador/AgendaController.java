package Controlador;

import Beans.Contacto;
import Modelo.Factories.FactoryPersonaDAO;
import Modelo.Contactos.ContactoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service(value = "controlador")
public class AgendaController {
    @Autowired
    @Qualifier("contactoDAO")
    private ContactoDAO contactoDao;

   /* public AgendaController() {
        inicialize();
    }

    private void inicialize(){
            contactoDao = new FactoryPersonaDAO().comprobarEstadoArchivoConfiguracion();
    }*/

    public void modificarPersona(Contacto contacto){
        contactoDao.modificarPersona(contacto);
    }

    public ArrayList<Contacto> recuperarAgendaPorMes(String mes, String usuario) {
        return contactoDao.recuperarTodasLasPersonas(mes,usuario);
    }

    public void eliminarPersonaid(int id, String user) {
        contactoDao.borrarPersona(id);
    }

    public Contacto recuperarPersona(int id) {
        return contactoDao.recuperarPersona(id);
    }

    public void anadirPersonaOnline(Contacto contacto) {
        contactoDao.guardarPersona(contacto);
    }


    public ArrayList<Contacto> recuperarAgendaCompleta(String usuario) {
        return contactoDao.recuperarTodasLasPersonas(usuario);
    }
}
