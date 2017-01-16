package Modelo.Personas;

import Beans.Contacto;
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


    public void modificarPersona(Contacto contacto, String user) {
        modificarPersonaOnline(contacto,user);
    }


    @Override
    public ArrayList<Contacto> recuperarTodasLasPersonas(String mes, String usuario) {
        ArrayList<Contacto> listaContactos =seleccionarTodasLasPersonasOnline(mes,usuario);
        return listaContactos;
    }

    @Override
    public Contacto recuperarPersona(int id) {
        return seleccionarPersona(id);
    }

    @Override
    public void guardarPersona(Contacto contacto, String user) {
        anadirPersonaOnline(contacto,user);
    }


    public boolean anadirPersonaOnline(Contacto contacto, String user) {
        String sql="Insert into agenda VALUES (NULL ,?,?,?,?,?);";
        try {
            PreparedStatement sentenciaPreparada=  conectorBD.getConnection().prepareStatement(sql);
            sentenciaPreparada.setString(1, contacto.getNombre());
            sentenciaPreparada.setString(2, contacto.getApellidos());
            sentenciaPreparada.setString(3, String.valueOf(contacto.getTelefono()));
            sentenciaPreparada.setString(4, contacto.getFecha());
            sentenciaPreparada.setString(5,user);
            sentenciaPreparada.executeUpdate();

        } catch (SQLException e) {
            System.out.println("no se ha pòdido introducir la contacto en la base de datos "+e);
            return false;
        }
        return true;

    }

    public void modificarPersonaOnline(Contacto contacto, String user) {
        String query = "update agenda set nombre=?, apellidos=?, telefono=?, FNaci=? where id=? and user=?";
        try{
            PreparedStatement sentenciaPreparada=  conectorBD.getConnection().prepareStatement(query);
            sentenciaPreparada.setString(1, contacto.getNombre());
            sentenciaPreparada.setInt(5, contacto.getId());
            sentenciaPreparada.setString(2, contacto.getApellidos());
            sentenciaPreparada.setString(3, String.valueOf(contacto.getTelefono()));
            sentenciaPreparada.setString(4, contacto.getFecha());
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

    public ArrayList<Contacto> seleccionarTodasLasPersonasOnline(String mes, String usuario) {
        ArrayList<Contacto> listaContactos = new ArrayList<>();
        try {
            String query = "SELECT * FROM agenda WHERE user='"+usuario+"' and MONTH (FNaci) like '"+mes+"';";
            Statement peticion = conectorBD.getConnection().createStatement();
            ResultSet resultSet = peticion.executeQuery(query);
            cogerPersonas(listaContactos, resultSet);
            System.out.println(query);
        } catch (SQLException e) {
            System.out.println("no se han podido mostrar los contactos " + e);
            return null;
        }
        return listaContactos;
    }

    private void cogerPersonas(ArrayList<Contacto> listaContactos, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            String telefono = resultSet.getString("telefono");
            String FNaci = resultSet.getString("FNaci");
            listaContactos.add(new Contacto(id,nombre, apellidos, telefono, FNaci));
        }
    }

    public Contacto seleccionarPersona(int id) {
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
                return new Contacto(id,nombre, apellidos, telefono, FNaci);
            }else return null;
        } catch (SQLException e) {
            System.out.println("no se han podido mostrar los contactos " + e);
            return null;
        }
    }

    public ArrayList<Contacto> seleccionarTodasLasPersonasOnline(String usuario) {
        ArrayList<Contacto> listaContactos = new ArrayList<>();
        try {
            String query = "SELECT * FROM agenda WHERE user='"+usuario+"';";
            Statement peticion = conectorBD.getConnection().createStatement();
            ResultSet resultSet = peticion.executeQuery(query);
            cogerPersonas(listaContactos, resultSet);


        } catch (SQLException e) {
            System.out.println("no se han podido mostrar los contactos " + e);
            return null;
        }
        return listaContactos;
    }

}

