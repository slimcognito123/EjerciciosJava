package DAO.Personas;

import Beans.Fecha;
import Beans.Persona;
import DAO.Ficheros.FicheroEscritura;
import DAO.Ficheros.FicheroLectura;

import java.util.ArrayList;

public class PersonaDAOFichero implements PersonaDAO {

    private static final String NOMBRE_FICHERO = "Agenda.txt";
    private FicheroLectura ficheroLectura;
    private FicheroEscritura ficheroEscritura;

    @Override
    public boolean guardarPersona(Persona persona) {
        ficheroEscritura = new FicheroEscritura(NOMBRE_FICHERO, true);
        ficheroEscritura.escribirLinea(persona.toString(true));
        ficheroEscritura.escribirLinea("");
        ficheroEscritura.cerrar();
        return true;
    }

    @Override
    public Persona recuperarPersona(String dni) {
        String linea = encontrarPersonaPorDNI(dni);
        if (linea == null) return null;
        return getPersona(linea);
    }

    @Override
    public ArrayList<Persona> recuperarTodasLasPersonas() {
        ficheroLectura = new FicheroLectura(NOMBRE_FICHERO);
        ArrayList<Persona> personaArrayList = new ArrayList<>();
        int cont = 0;
        String linea;
        do {
            linea = ficheroLectura.leerLinea();
            if (linea != null && !linea.equals("")) personaArrayList.add(getPersona(linea));
            cont++;
        } while (linea != null);
        if (cont <= 1) return null;
        return personaArrayList;
    }

    @Override
    public Boolean borrarPersona(String dni) {
        ArrayList<Persona> listaPersonas = recuperarTodasLasPersonas();
        ficheroEscritura=new FicheroEscritura(NOMBRE_FICHERO,false);
        for (Persona persona : listaPersonas) {
            if(!persona.getDni().equals(dni)){
                ficheroEscritura.escribirLinea(persona.toString(true));
            }
        }
        ficheroEscritura.cerrar();
        return null;
    }

    private Persona getPersona(String linea) {
        String[] personaCortada = linea.split("-");
        String nombre = personaCortada[1];
        String apellidos = personaCortada[2];
        String dni1 = personaCortada[0];
        int telefono = Integer.parseInt(personaCortada[3]);
        int dia = Integer.parseInt(personaCortada[4].split("/")[0]);
        int mes = Integer.parseInt(personaCortada[4].split("/")[1]);
        int anio = Integer.parseInt(personaCortada[4].split("/")[2]);
        Fecha fecha = new Fecha(dia, mes, anio);

        return new Persona(nombre, apellidos, dni1, telefono, fecha);
    }

    private String encontrarPersonaPorDNI(String dni) {
        ficheroLectura = new FicheroLectura(NOMBRE_FICHERO);
        String linea = ficheroLectura.leerLinea();
        while (linea != null && !linea.split("-")[0].equalsIgnoreCase(dni)) {
            linea = ficheroLectura.leerLinea();
        }
        return linea;
    }
    @Override
    public Persona modificarPersona(Persona persona) {
        return null;
    }

    @Override
    public ArrayList<Persona> recuperarTodasLasPersonas(String usuario) {
        return null;
    }
}
