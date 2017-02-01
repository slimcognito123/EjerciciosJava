package Modelo.DAO.Usuarios;

import Beans.Usuario;
import Modelo.DAO.BaseDatos.ConectorBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDAO {
    private ConectorBD conectorBD;

    public UsuarioDAO() {
        if (conectorBD == null) conectorBD = new ConectorBD();
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
}
