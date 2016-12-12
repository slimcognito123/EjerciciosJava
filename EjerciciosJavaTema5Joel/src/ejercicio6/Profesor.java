package ejercicio6;

public class Profesor extends Empleado {
	
	private String departamento;
	protected final double CANTIDADFIJAP = 1500.0;

	public Profesor(String nombre, String apellidos, String numero, String estado, int anioIngreso, String numDespacho, String departamento) {
		super(nombre, apellidos, numero, estado, anioIngreso, numDespacho);
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return departamento;
	}
	public void cambiarDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public double calcularSalario() {
		salario = CANTIDADFIJAP;
		if(anioIngreso < 2000){
			salario *= 108.0/100; 
		}
		return salario;
	}
	
	@Override
	public void imprimirInfo() {
		System.out.println("PROFESOR[nombre=" + nombre + ", apellidos=" + apellidos + ", numero=" + numero
				+ ", estado=" + estado + "\n        departamento=" + departamento + ", anioIngreso=" + anioIngreso + ", numDespacho=" + numDespacho
				+ ", salario=" + salario + "]");
	}

	@Override
	public void imprimirSalario() {
		System.out.println("PROFESOR[nombre=" + nombre + ", apellidos=" + apellidos + ", sueldo=" + calcularSalario() + "]");
		
	}	
	
}
