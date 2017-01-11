package Negocio;

import Beans.Persona;
import DAO.Factories.FactoryPersonaDAO;
import DAO.Personas.PersonaDAO;
import Exceptions.MyException;

import java.util.ArrayList;

public class Agenda {

    private PersonaDAO personaDao;

    public Agenda() {
        inicialize();
    }

    private void inicialize(){
        try {
            personaDao = new FactoryPersonaDAO().comprobarEstadoArchivoConfiguracion();
        } catch (MyException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void aniadirPersona(Persona p) {
        personaDao.guardarPersona(p);
    }

    public void borrarPersonaPorDni(String dni) {
        personaDao.borrarPersona(dni);
    }

    public Persona buscarPersonaPorDni(String dni) {
        return personaDao.recuperarPersona(dni);
    }

    public ArrayList<Persona> recuperarAgenda() {
        return personaDao.recuperarTodasLasPersonas();
    }

    public ArrayList<Persona> listarPorMesCumple(int mes) {
        ArrayList<Persona> listaPersonas = personaDao.recuperarTodasLasPersonas();
        ArrayList<Persona> aux = new ArrayList<>();
        for (Persona persona : listaPersonas) {
            if (persona.getFecha().getMes() == mes) {
                aux.add(persona);
            }
        }
        return aux;
    }
    public void modificarPersona(Persona persona){
        personaDao.modificarPersona(persona);
    }

    public ArrayList<Persona> recuperarAgenda(String usuario) {
        return personaDao.recuperarTodasLasPersonas(usuario);
    }
}
