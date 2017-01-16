package Controlador;

import Beans.Contacto;
import Modelo.Factories.FactoryPersonaDAO;
import Modelo.Personas.PersonaDAO;

import java.util.ArrayList;

public class AgendaController {

    private PersonaDAO personaDao;

    public AgendaController() {
        inicialize();
    }

    private void inicialize(){
            personaDao = new FactoryPersonaDAO().comprobarEstadoArchivoConfiguracion();

    }

    public void modificarPersona(Contacto contacto, String user){
        personaDao.modificarPersona(contacto,user);
    }

    public ArrayList<Contacto> recuperarAgendaPorMes(String mes, String usuario) {
        return personaDao.recuperarTodasLasPersonas(mes,usuario);
    }

    public void eliminarPersonaid(int id, String user) {
        personaDao.borrarPersona(id,user);
    }

    public Contacto recuperarPersona(int id) {
        return personaDao.recuperarPersona(id);
    }

    public void anadirPersonaOnline(Contacto contacto, String user) {
        personaDao.guardarPersona(contacto,user);
    }
}
