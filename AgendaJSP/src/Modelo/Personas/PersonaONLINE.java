package Modelo.Personas;

import Beans.Persona;
import Modelo.BaseDatos.EscritorBD;
import Modelo.BaseDatos.LectorBD;

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

    /*public Persona recuperarPersona(int id, String usuario) {
        return null;
    }*/

    @Override
    public boolean guardarPersona(Persona persona) {
        return false;
    }

    public ArrayList<Persona> recuperarTodasLasPersonas() {

        ArrayList<Persona> listaPersonas=lectorBD.seleccionarTodasLasPersonas();
        return listaPersonas;
    }

    @Override
    public Boolean borrarPersona(int id, String usuario) {
        return escritorBD.eliminarPersonaOnline(id,usuario);
    }


    public Boolean borrarPersona(int id) {
        return escritorBD.eliminarPersona(id);
    }

    public void modificarPersona(Persona persona, String user) {
        escritorBD.modificarPersonaOnline(persona,user);
    }

    @Override
    public ArrayList<Persona> recuperarTodasLasPersonas(String usuario) {

        ArrayList<Persona> listaPersonas=lectorBD.seleccionarTodasLasPersonasOnline(usuario);
        return listaPersonas;
    }

    @Override
    public ArrayList<Persona> recuperarTodasLasPersonas(String mes, String usuario) {
        ArrayList<Persona> listaPersonas=lectorBD.seleccionarTodasLasPersonasOnline(mes,usuario);
        return listaPersonas;
    }

    @Override
    public Persona recuperarPersona(int id) {
        return lectorBD.seleccionarPersona(id);
    }

    @Override
    public void guardarPersona(Persona persona, String user) {
        escritorBD.anadirPersonaOnline(persona,user);
    }

}
