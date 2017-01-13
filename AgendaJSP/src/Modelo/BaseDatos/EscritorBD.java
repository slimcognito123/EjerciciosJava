package Modelo.BaseDatos;

import Beans.Persona;
import Beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EscritorBD {

    private ConectorBD conectorBD;

    public EscritorBD() {
        if(conectorBD== null) conectorBD=new ConectorBD();
    }



    public Boolean eliminarPersona(int dni) {
        try {
            Statement peticion = conectorBD.getConnection().createStatement();
            String query = "delete from agenda where dni='"+dni+"';";
            peticion.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("NO se ha podido eliminar con exito");
            return false;
        }
        return true;
    }

    public Persona modificarPersona(Persona persona) {
        String query = "update agenda set nombre=? apellidos=? telefono=? FNaci=? where dni=?";
        try {
            Statement peticion = conectorBD.getConnection().prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertarUsuario(Usuario user) {
        String sql="Insert into usuarios VALUES (?,?);";
        try {
            PreparedStatement sentenciaPreparada=  conectorBD.getConnection().prepareStatement(sql);
            sentenciaPreparada.setString(1,user.getNombre());
            sentenciaPreparada.setString(2,user.getPassword());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("no se ha pòdido crear el usuario "+user.getNombre()+" "+user.getPassword()+" "+e);
        }
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
}
