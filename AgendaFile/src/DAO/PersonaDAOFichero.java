package DAO;

import Beans.Fecha;
import Beans.Persona;

import java.util.ArrayList;

public class PersonaDAOFichero implements PersonaDAO {
    private FicheroLectura ficheroLectura;
    private FicheroEscritura ficheroEscritura;

    @Override
    public boolean guardarPersona(Persona persona) {
        ficheroEscritura = new FicheroEscritura("Agenda.txt", true);
        ficheroEscritura.escribirLinea(persona.toString());
        ficheroEscritura.escribirLinea("");
        ficheroEscritura.cerrar();
        return true;
    }

    @Override
    public Persona recuperarPersona(String dni) {
        ficheroLectura = new FicheroLectura("Agenda.txt");
        if (ficheroLectura==null) return null;
        String linea=ficheroLectura.leerLinea();
        while(linea.split("-")[0]!=dni){
            linea=ficheroLectura.leerLinea();
        }
        String[] personaCortada= linea.split("  ");
       return new Persona(personaCortada[1],personaCortada[2],personaCortada[0],Integer.parseInt(personaCortada[3]),new Fecha(Integer.parseInt(personaCortada[4].split("/")[0]),Integer.parseInt(personaCortada[4].split("/")[1]),Integer.parseInt(personaCortada[4].split("/")[2])));
    }

    @Override
    public ArrayList<Persona> recuperarTodasLasPersonas() {
        return null;
    }

    @Override
    public Boolean borrarPersona(String dni) {
        return null;
    }
}
