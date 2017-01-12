package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.DateFormatter;

import beans.Persona;
import dao.AgenteConexion;

public class PersonaDAOJdbc implements PersonaDao {
	
	Connection conn = AgenteConexion.getAgenteConexion().conexion;

	public boolean guardarPersona(Persona persona) {
		DateTimeFormatter formateador= DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String sql = "INSERT INTO contactos VALUES(null,"
				+ "'" + persona.getNombre() + " ',"
				+ "'" + persona.getApellidos() + "',"
				+ "'" + persona.getTelefono() + "',"
				+ "'" + persona.getFecha().format(formateador) +
				"');";
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(sql);
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql);
		}
		return true;
	}
	
	public ArrayList<Persona> recuperarContactosDe(String nombreUsuario) {
		
		ArrayList<Persona> aux = new ArrayList<Persona>();
		
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM contactos where nombreUsuario="+'"'+nombreUsuario+'"');
			
			while (rs.next()) {
	            String nombre = rs.getString("nombre");
	    		String apellidos = rs.getString("apellidos");
	    		int id = rs.getInt("id");
	    		String telefono = rs.getString("telefono");
	    		Date d=rs.getDate("fecha");
	    		LocalDate localDate= LocalDate.of(d.getYear()+1900, d.getMonth()+1, d.getDate()); 
	    		Persona persona = new Persona(id,nombre, apellidos,telefono, localDate);
	    		aux.add(persona);
			}
			st.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}
	
	public Persona recuperarPersona(int id) {
		Persona persona = null;
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM contactos WHERE id="+ id );
			while (rs.next()) {
				 String nombre = rs.getString("nombre");
		    		String apellidos = rs.getString("apellidos");
		    		String telefono = rs.getString("telefono");
		    		Date d=rs.getDate("fecha");
		    		LocalDate localDate= LocalDate.of(d.getYear()+1900, d.getMonth()+1, d.getDate()); 
		    		persona = new Persona(id,nombre, apellidos,telefono, localDate);
		    		return persona;
			}
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persona;
	}

	public boolean borrarPersona(int id) {
		
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM contactos WHERE id=" + id );
			st.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean modificarPersona(Persona persona){
		Statement st;
		try {
			DateTimeFormatter formateador= DateTimeFormatter.ofPattern("yyyy-MM-dd");
			st = conn.createStatement();
			System.out.println("UPDATE contactos SET nombre=\"" + persona.getNombre() +"\","
					+ "apellidos =\"" + persona.getApellidos() +"\","
					+ "telefono =\"" + persona.getTelefono() +"\","
					+ "fecha =\"" + persona.getFecha().format(formateador)+"\""
					+ "WHERE id =" + persona.getId());
			st.executeUpdate("UPDATE contactos SET nombre=\"" + persona.getNombre() +"\","
					+ "apellidos =\"" + persona.getApellidos() +"\","
					+ "telefono =\"" + persona.getTelefono() +"\","
					+ "fecha =\"" + persona.getFecha().format(formateador)+"\""
					+ "WHERE id =" + persona.getId() );
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
