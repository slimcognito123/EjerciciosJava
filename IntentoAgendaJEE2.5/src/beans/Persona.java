package beans;

import java.time.LocalDate;

public class Persona {
	
	private int id;
	private String nombre;
	private String apellidos;
	private String telefono;
	private LocalDate fecha;
	
	public Persona(int id, String nombre, String apellidos, String telefono, LocalDate fecha) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id = id;
		this.telefono = telefono;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
		
}
