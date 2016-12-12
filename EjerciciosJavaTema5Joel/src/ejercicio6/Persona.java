package ejercicio6;

public abstract class Persona {
	
	protected String nombre;
	protected String apellidos;
	protected String numero;
	protected String estado;
	
	public Persona(String nombre, String apellidos, String numero, String estado) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.numero = numero;
		this.estado = estado;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void cambiarEstado(String estado) {
		this.estado = estado;
	}
	
	public abstract void imprimirInfo();
}
