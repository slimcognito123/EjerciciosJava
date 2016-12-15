package Negocio;

import Beans.Persona;
import DAO.Factories.FactoryPersonaDAO;
import DAO.Ficheros.FicheroLectura;
import DAO.Personas.PersonaDAO;
import DAO.Personas.PersonaDAOFichero;
import DAO.Personas.PersonaDAOJDBC;
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

    }
}
