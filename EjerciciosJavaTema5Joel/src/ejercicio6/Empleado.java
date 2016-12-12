package ejercicio6;

public abstract class Empleado extends Persona {
	
	protected int anioIngreso;
	protected String numDespacho;
	protected double salario;
	
	public Empleado(String nombre, String apellidos, String numero, String estado, int anioIngreso, String numDespacho) {
		super(nombre, apellidos, numero, estado);
		this.anioIngreso = anioIngreso;
		this.numDespacho = numDespacho;
		this.salario = calcularSalario();
	}
		
	public int getAnioIngreso() {
		return anioIngreso;
	}
	public void setAnioIngreso(int anioIngreso) {
		this.anioIngreso = anioIngreso;
	}
	public String getNumDespacho() {
		return numDespacho;
	}
	public void setNumDespacho(String numDespacho) {
		this.numDespacho = numDespacho;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void reasignarDespacho(String despacho){
		this.numDespacho = despacho;
	}
	
	public abstract double calcularSalario();

	public abstract void imprimirSalario();
	
	@Override
	public abstract void imprimirInfo();
	
}
