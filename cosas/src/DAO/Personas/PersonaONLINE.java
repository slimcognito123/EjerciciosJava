package DAO.Personas;

import Beans.Persona;
import DAO.BaseDatos.EscritorBD;
import DAO.BaseDatos.LectorBD;

import java.util.ArrayList;

/**
 * Created by Patata kawaii on 10/01/2017.
 */
public class PersonaONLINE implements PersonaDAO {
    private LectorBD lectorBD;
    private EscritorBD escritorBD;

    public PersonaONLINE() {
        lectorBD = new LectorBD();
        escritorBD = new EscritorBD();
    }

    public boolean guardarPersona(Persona persona) {
        return escritorBD.insertar(persona);
    }

    public Persona recuperarPersona(String dni) {
        return lectorBD.seleccionarPersona(dni);
    }

    public ArrayList<Persona> recuperarTodasLasPersonas() {

        ArrayList<Persona> listaPersonas=lectorBD.seleccionarTodasLasPersonas();
        return listaPersonas;
    }

    public Boolean borrarPersona(String dni) {
        return escritorBD.eliminarPersona(dni);
    }

    public Persona modificarPersona(Persona persona) {
        return escritorBD.modificarPersona(persona);
    }

    @Override
    public ArrayList<Persona> recuperarTodasLasPersonas(String usuario) {

        ArrayList<Persona> listaPersonas=lectorBD.seleccionarTodasLasPersonasOnline(usuario);
        return listaPersonas;
    }
}
