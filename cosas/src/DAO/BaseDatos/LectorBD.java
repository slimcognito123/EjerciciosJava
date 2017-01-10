package DAO.BaseDatos;

import Beans.Fecha;
import Beans.Persona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LectorBD {

    private ConectorBD conectorBD;

    public LectorBD() {
        if (conectorBD == null) conectorBD = new ConectorBD();
    }

    public Persona seleccionarPersona(String dni) {
        Persona persona = null;
        try {
            String query = "SELECT * FROM agenda where dni = '" + dni + "';";
            Statement peticion = conectorBD.getConnection().createStatement();
            ResultSet resultSet = peticion.executeQuery(query);
            resultSet.next();
            String nombre = resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            String telefono = resultSet.getString("telefono");
            String FNaci = resultSet.getString("FNaci");

            int dia = Integer.parseInt(FNaci.split("-")[0]);
            int mes = Integer.parseInt(FNaci.split("-")[1]);
            int ano = Integer.parseInt(FNaci.split("-")[2]);
            persona = new Persona(nombre, apellidos, dni, Integer.parseInt(telefono), new Fecha(dia, mes, ano));

        } catch (SQLException e) {
            System.out.println("no se han podido mostrar los contactos " + e);
            return null;
        }
        return persona;
    }

    public ArrayList<Persona> seleccionarTodasLasPersonas() {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        try {
            String query = "SELECT * FROM agenda;";
            Statement peticion = conectorBD.getConnection().createStatement();
            ResultSet resultSet = peticion.executeQuery(query);
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String telefono = resultSet.getString("telefono");
                String FNaci = resultSet.getString("FNaci");
                String dni = resultSet.getString("dni");
                int dia = Integer.parseInt(FNaci.split("-")[0]);
                int mes = Integer.parseInt(FNaci.split("-")[1]);
                int ano = Integer.parseInt(FNaci.split("-")[2]);
                listaPersonas.add(new Persona(nombre, apellidos, dni, Integer.parseInt(telefono), new Fecha(dia, mes, ano)));
            }


        } catch (SQLException e) {
            System.out.println("no se han podido mostrar los contactos " + e);
            return null;
        }
        return listaPersonas;
    }

    public boolean comprobarUser(String user, String pass) {
        String query = "select * from usuarios where nomUsuario='" + user + "';";
        try {
            Statement peticion = conectorBD.getConnection().createStatement();
            System.out.println(user);
            ResultSet resultSet = peticion.executeQuery(query);
            if (resultSet.next()) {
                if (pass.compareTo(resultSet.getString("password")) == 0){
                    return true;
                }else{
                    System.out.println(pass.compareTo(resultSet.getString("password")));
                    return false;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Persona> seleccionarTodasLasPersonasOnline(String usuario) {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        try {
            String query = "SELECT * FROM agenda WHERE user='"+usuario+"';";
            Statement peticion = conectorBD.getConnection().createStatement();
            ResultSet resultSet = peticion.executeQuery(query);
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String telefono = resultSet.getString("telefono");
                String FNaci = resultSet.getString("FNaci");
                String dni = resultSet.getString("dni");
                int dia = Integer.parseInt(FNaci.split("-")[0]);
                int mes = Integer.parseInt(FNaci.split("-")[1]);
                int ano = Integer.parseInt(FNaci.split("-")[2]);
                listaPersonas.add(new Persona(nombre, apellidos, dni, Integer.parseInt(telefono), new Fecha(dia, mes, ano)));
            }


        } catch (SQLException e) {
            System.out.println("no se han podido mostrar los contactos " + e);
            return null;
        }
        return listaPersonas;
    }
}
