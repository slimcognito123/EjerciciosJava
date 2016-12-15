package DAO.BaseDatos;

import Beans.Persona;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LectorBD {

    private ConectorBD conectorBD;

    public LectorBD() {
        if(conectorBD== null) conectorBD=new ConectorBD();
    }

    public Persona seleccionarPersona(String dni) {
        Persona persona = null;
        try {
            String query = "SELECT * FROM agenda where dni = '"+dni+"';";
            Statement peticion = conectorBD.getConnection().createStatement();
        } catch (SQLException e) {
            System.out.println("no se han podido mostrar los contactos "+e);
            return null;
        }
        return persona;
    }

    public ArrayList<Persona> seleccionarTodasLasPersonas() {
        return null;
    }
}
