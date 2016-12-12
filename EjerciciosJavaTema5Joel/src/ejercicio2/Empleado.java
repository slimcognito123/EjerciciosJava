package ejercicio2;

public class Empleado {
	protected String nombre;
	protected String nif;
	protected int edad;
	protected boolean casado;
	protected double salario;

	public Empleado() {
		nombre = "Paco";
		nif = "1234567R";
		edad = 28;
		casado = true;
		salario = 1400.0;
	}

	public Empleado(String nombre, String nif, int edad, boolean casado, double salario) {
		this.nombre = nombre;
		this.nif = nif;
		this.edad = edad;
		this.casado = casado;
		this.salario = salario;
	}

	public void mostrarClasificacion() {
		String clasificacion = "";
		if (edad <= 21) {
			clasificacion = "Principiante";
		} else if (edad >= 22 && edad <= 35) {
			clasificacion = "Intermedio";
		} else {
			clasificacion = "Senior";
		}
		System.out.println("Clasificación: " + clasificacion);
	}
	
	public void imprimirDatos(){
		String datos = "Nombre: "+nombre+"\n"+
	                  "NIF: "+nif+"\n"+
	                  "Edad: "+edad+"\n"+
	                  "Casado: "+casado+"\n"+
	                  "Salario: "+salario+"\n";
	    System.out.print(datos);
		mostrarClasificacion();
	}
	
	public void aumentarSalario(double porcentaje){
		salario += porcentaje*salario/100;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isCasado() {
		return casado;
	}

	public void setCasado(boolean casado) {
		this.casado = casado;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
