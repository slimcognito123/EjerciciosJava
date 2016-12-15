package DAO.Personas;

import Beans.Persona;
import DAO.BaseDatos.EscritorBD;
import DAO.BaseDatos.LectorBD;

import java.util.ArrayList;

public class PersonaDAOJDBC implements PersonaDAO {
    private LectorBD lectorBD;
    private EscritorBD escritorBD;

    public PersonaDAOJDBC() {
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

    @Override
    public Persona modificarPersona(Persona persona) {
        return escritorBD.modificarPersona(persona);
    }
}
