package Modelo.BaseDatos;

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

    public ArrayList<Persona> seleccionarTodasLasPersonas() {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        try {
            String query = "SELECT * FROM agenda;";
            Statement peticion = conectorBD.getConnection().createStatement();
            ResultSet resultSet = peticion.executeQuery(query);
            cogerPersonas(listaPersonas, resultSet);


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
            cogerPersonas(listaPersonas, resultSet);


        } catch (SQLException e) {
            System.out.println("no se han podido mostrar los contactos " + e);
            return null;
        }
        return listaPersonas;
    }

    private void cogerPersonas(ArrayList<Persona> listaPersonas, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            String telefono = resultSet.getString("telefono");
            String FNaci = resultSet.getString("FNaci");
            listaPersonas.add(new Persona(id,nombre, apellidos, telefono, FNaci));
        }
    }

    public boolean buscarUsuarioRepetido(String usuario) {
        try {
            String query = "SELECT * FROM usuarios WHERE NomUsuario='"+usuario+"';";
            Statement peticion = conectorBD.getConnection().createStatement();
            ResultSet resultSet = peticion.executeQuery(query);
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            System.out.println("no se ha podido buscar correctamente " + e);
            //se da por repetido el usuario ya que ha surgido un problema
            return true;
        }
        return false;
    }

    public ArrayList<Persona> seleccionarTodasLasPersonasOnline(String mes, String usuario) {
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        try {
            String query = "SELECT * FROM agenda WHERE user='"+usuario+"' and MONTH (FNaci) like '"+mes+"';";
            Statement peticion = conectorBD.getConnection().createStatement();
            ResultSet resultSet = peticion.executeQuery(query);
            cogerPersonas(listaPersonas, resultSet);
            System.out.println(query);
        } catch (SQLException e) {
            System.out.println("no se han podido mostrar los contactos " + e);
            return null;
        }
        return listaPersonas;
    }

    public Persona seleccionarPersona(int id) {
        try {
            String query = "SELECT * FROM agenda WHERE id='"+id+"';";
            Statement peticion = conectorBD.getConnection().createStatement();
            ResultSet resultSet = peticion.executeQuery(query);
            System.out.println(query);
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String telefono = resultSet.getString("telefono");
                String FNaci = resultSet.getString("FNaci");
                return new Persona(id,nombre, apellidos, telefono, FNaci);
            }else return null;
        } catch (SQLException e) {
            System.out.println("no se han podido mostrar los contactos " + e);
            return null;
        }
    }
}
