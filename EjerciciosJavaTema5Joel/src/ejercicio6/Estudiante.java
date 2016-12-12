package ejercicio6;

public class Estudiante extends Persona {
	
	private String curso;
	
	public Estudiante(String nombre, String apellidos, String numero, String estado, String curso) {
		super(nombre, apellidos, numero, estado);
		this.curso = curso;
	}

	
	
	public String getCurso() {
		return curso;
	}
	public void matricularCurso(String curso) {
		this.curso = curso;
	}



	@Override
	public void imprimirInfo() {
		System.out.println("ESTUDIANTE[nombre=" + nombre + ", apellidos=" + apellidos + ", numero=" + numero
				+ ", estado=" + estado + ", curso=" + curso + "]");
	}

}
