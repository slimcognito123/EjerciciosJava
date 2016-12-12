package ejercicio5;

public abstract class Instrumento {

	protected String nombre;

	public Instrumento(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract void tocar();
	
	
}
