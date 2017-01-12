package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;

import beans.Usuario;

public class UsuarioDAOJdbc implements UsuarioDAO{

	Connection conn = AgenteConexion.getAgenteConexion().conexion;
	@Override
	public boolean guardarUsuario(Usuario u) {
		try {
		Statement st = conn.createStatement();
		st.executeUpdate("INSERT INTO usuarios VALUES("
							+ "\""+ u.getNombre() +" \","
							+ "\""+ u.getPassword() +"\""
							+")");
		st.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
   }
	
	@Override
	public Usuario recuperarUsuario(String nombre) {
		
		Statement st;
		try {
		st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM usuarios where nombre="+'"'+nombre+'"');
		if(rs.next()){
			String pass= rs.getString("password");
			Usuario u= new Usuario(nombre,pass);
			return u;
		}else
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
