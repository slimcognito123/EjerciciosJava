package Negocio;

import Beans.Persona;
import DAO.PersonaDAOFichero;

import java.util.ArrayList;

public class Agenda {

    private DAO.PersonaDAO personaDao;

    public Agenda() {
        personaDao = new PersonaDAOFichero();
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

}
