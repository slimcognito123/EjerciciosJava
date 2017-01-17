package Controlador;

import Beans.Contacto;
import Modelo.Factories.FactoryPersonaDAO;
import Modelo.Contactos.ContactoDAO;

import java.util.ArrayList;

public class AgendaController {

    private ContactoDAO contactoDao;

    public AgendaController() {
        inicialize();
    }

    private void inicialize(){
            contactoDao = new FactoryPersonaDAO().comprobarEstadoArchivoConfiguracion();

    }

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
