package ejercicio6;

public class PersonalServicio extends Empleado {
	
	private String seccion;
	protected final double CANTIDADFIJAPS = 1200.0;

	public PersonalServicio(String nombre, String apellidos, String numero, String estado, int anioIngreso, String numDespacho, String seccion) {
		super(nombre, apellidos, numero, estado, anioIngreso, numDespacho);
		this.seccion = seccion;
	}

	public String getSeccion() {
		return seccion;
	}
	public void cambiarSeccion(String seccion) {
		this.seccion = seccion;
	}

	@Override
	public double calcularSalario() {
		salario = CANTIDADFIJAPS;
		if(estado.equalsIgnoreCase("casado")){
			salario *= 105.0/100; 
		}
		return salario;
	}

	@Override
	public void imprimirInfo() {
		System.out.println("PERSONAL SERVICIO[nombre=" + nombre + ", apellidos=" + apellidos + ", numero=" + numero
				+ ", estado=" + estado + "\n        seccion=" + seccion + ", anioIngreso=" + anioIngreso + ", numDespacho=" + numDespacho
				+ ", salario=" + salario + "]");
		
	}
	
	@Override
	public void imprimirSalario() {
		System.out.println("PERSONAL SERVICIO[nombre=" + nombre + ", apellidos=" + apellidos + ", sueldo=" + calcularSalario() + "]");
		
	}	

}
