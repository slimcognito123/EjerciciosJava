package ejercicio2;

public class Programador extends Empleado {
	private int lineasDeCodigoPorHora;
	private String lenguajeDominante;

	public Programador() {
		super();
		lineasDeCodigoPorHora = 200;
		lenguajeDominante = "JAVA";
	}

	public Programador(String nombre, String nif, int edad, boolean casado, double salario, int lineas, String lenguaje) {
		super(nombre, nif, edad, casado, salario);
		this.lineasDeCodigoPorHora = lineas;
		this.lenguajeDominante = lenguaje;
	}

	public int getLineasDeCodigoPorHora() {
		return lineasDeCodigoPorHora;
	}

	public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
		this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
	}

	public String getLenguajeDominante() {
		return lenguajeDominante;
	}

	public void setLenguajeDominante(String lenguajeDominante) {
		this.lenguajeDominante = lenguajeDominante;
	}

	

}
