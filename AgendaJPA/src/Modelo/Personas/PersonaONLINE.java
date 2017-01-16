package Modelo.Personas;

import Beans.Persona;
import Modelo.BaseDatos.ConectorBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Patata kawaii on 10/01/2017.
 */
public class PersonaONLINE implements PersonaDAO {
    private ConectorBD conectorBD;

    public PersonaONLINE() {
        conectorBD = new ConectorBD();
    }

    @Override
    public Boolean borrarPersona(int id, String usuario) {
        return eliminarPersonaOnline(id,usuario);
    }


    public void modificarPersona(Persona persona, String user) {
        modificarPersonaOnline(persona,user);
    }


    @Override
    public ArrayList<Persona> recuperarTodasLasPersonas(String mes, String usuario) {
        ArrayList<Persona> listaPersonas=seleccionarTodasLasPersonasOnline(mes,usuario);
        return listaPersonas;
    }

    @Override
    public Persona recuperarPersona(int id) {
        return seleccionarPersona(id);
    }

    @Override
    public void guardarPersona(Persona persona, String user) {
        anadirPersonaOnline(persona,user);
    }


    public boolean anadirPersonaOnline(Persona persona, String user) {
        String sql="Insert into agenda VALUES (NULL ,?,?,?,?,?);";
        try {
            PreparedStatement sentenciaPreparada=  conectorBD.getConnection().prepareStatement(sql);
            sentenciaPreparada.setString(1,persona.getNombre());
            sentenciaPreparada.setString(2,persona.getApellidos());
            sentenciaPreparada.setString(3, String.valueOf(persona.getTelefono()));
            sentenciaPreparada.setString(4, persona.getFecha());
            sentenciaPreparada.setString(5,user);
            sentenciaPreparada.executeUpdate();

        } catch (SQLException e) {
            System.out.println("no se ha pòdido introducir la persona en la base de datos "+e);
            return false;
        }
        return true;

    }

    public void modificarPersonaOnline(Persona persona, String user) {
        String query = "update agenda set nombre=?, apellidos=?, telefono=?, FNaci=? where id=? and user=?";
        try{
            PreparedStatement sentenciaPreparada=  conectorBD.getConnection().prepareStatement(query);
            sentenciaPreparada.setString(1,persona.getNombre());
            sentenciaPreparada.setInt(5,persona.getId());
            sentenciaPreparada.setString(2,persona.getApellidos());
            sentenciaPreparada.setString(3, String.valueOf(persona.getTelefono()));
            sentenciaPreparada.setString(4, persona.getFecha());
            sentenciaPreparada.setString(6,user);
            System.out.println(query);
            System.out.println(sentenciaPreparada);
            sentenciaPreparada.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public boolean eliminarPersonaOnline(int id, Object user) {
        try {
            Statement peticion = conectorBD.getConnection().createStatement();
            String query = "delete from agenda where id='"+id+"' and user='"+user+"';";
            peticion.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("NO se ha podido eliminar con exito usuario ="+user);
            return false;
        }
        return true;
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

}

