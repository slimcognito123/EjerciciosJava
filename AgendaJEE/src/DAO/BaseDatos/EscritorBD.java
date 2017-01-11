package DAO.BaseDatos;

import Beans.Persona;
import DAO.Usuarios.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class EscritorBD {

    private ConectorBD conectorBD;

    public EscritorBD() {
        if(conectorBD== null) conectorBD=new ConectorBD();
    }

    public boolean insertar(Persona persona) {
        String sql="Insert into agendabd.agenda VALUES (?,?,?,?,?);";
        try {
            PreparedStatement sentenciaPreparada=  conectorBD.getConnection().prepareStatement(sql);
            sentenciaPreparada.setString(1,persona.getDni());
            sentenciaPreparada.setString(2,persona.getNombre());
            sentenciaPreparada.setString(3,persona.getApellidos());
            sentenciaPreparada.setString(4, String.valueOf(persona.getTelefono()));

            String diaFechaNacimiento = String.valueOf(persona.getFecha().getDia());
            String mesFechaNacimiento = String.valueOf(persona.getFecha().getMes());
            String anoFechaNacimiento = String.valueOf(persona.getFecha().getAnio());

            sentenciaPreparada.setString(5, diaFechaNacimiento+"-"+ mesFechaNacimiento+"-"+ anoFechaNacimiento);
            sentenciaPreparada.executeUpdate();

        } catch (SQLException e) {
            System.out.println("no se ha pòdido introducir la persona en la base de datos "+e);
            return false;
        }
        return true;
    }

    public Boolean eliminarPersona(String dni) {
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
        String sql="Insert into agendabd.usuarios VALUES (?,?,?);";
        try {
            PreparedStatement sentenciaPreparada=  conectorBD.getConnection().prepareStatement(sql);
            sentenciaPreparada.setString(1,user.getNomUsuario());
            sentenciaPreparada.setString(2,user.getPassword());
            sentenciaPreparada.setString(3,user.getEmail());
            sentenciaPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("no se ha pòdido crear el usuario "+e);
        }
    }

    public boolean anadirPersonaOnline(Persona persona, String user) {
        String sql="Insert into agendabd.agenda VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement sentenciaPreparada=  conectorBD.getConnection().prepareStatement(sql);
            sentenciaPreparada.setString(1,persona.getDni());
            sentenciaPreparada.setString(2,persona.getNombre());
            sentenciaPreparada.setString(3,persona.getApellidos());
            sentenciaPreparada.setString(4, String.valueOf(persona.getTelefono()));

            String diaFechaNacimiento = String.valueOf(persona.getFecha().getDia());
            String mesFechaNacimiento = String.valueOf(persona.getFecha().getMes());
            String anoFechaNacimiento = String.valueOf(persona.getFecha().getAnio());

            sentenciaPreparada.setString(5, diaFechaNacimiento+"-"+ mesFechaNacimiento+"-"+ anoFechaNacimiento);
            sentenciaPreparada.setString(6,user);
            sentenciaPreparada.executeUpdate();

        } catch (SQLException e) {
            System.out.println("no se ha pòdido introducir la persona en la base de datos "+e);
            return false;
        }
        return true;

    }
}
