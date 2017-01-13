package Controlador;

import Beans.Persona;
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

    public void aniadirPersona(Persona p) {
        personaDao.guardarPersona(p);
    }

    public ArrayList<Persona> recuperarAgenda() {
        return personaDao.recuperarTodasLasPersonas();
    }

    public void modificarPersona(Persona persona, String user){
        personaDao.modificarPersona(persona,user);
    }

    public ArrayList<Persona> recuperarAgenda(String usuario) {
        return personaDao.recuperarTodasLasPersonas(usuario);
    }

    public ArrayList<Persona> recuperarAgendaPorMes(String mes, String usuario) {
        return personaDao.recuperarTodasLasPersonas(mes,usuario);
    }

    public void eliminarPersonaid(int id, String user) {
        personaDao.borrarPersona(id,user);
    }

    public Persona recuperarPersona(int id) {
        return personaDao.recuperarPersona(id);
    }

    public void anadirPersonaOnline(Persona persona, String user) {
        personaDao.guardarPersona(persona,user);
    }
}
