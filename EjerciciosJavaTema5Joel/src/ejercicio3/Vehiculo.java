package ejercicio3;

public abstract class Vehiculo {
	protected String matricula;
	protected double kilometraje;
	protected boolean alquilado;
	protected double importe;
	
	
	public Vehiculo(String matricula, double kilometraje, boolean alquilado, double importe) {
		this.matricula = matricula;
		this.kilometraje = kilometraje;
		this.alquilado = alquilado;
		this.importe = importe;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}

	public double getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void alquilar(){
		alquilado = true;
		kilometraje = 0.0;
	}
	
	public void devolver(double km){
		alquilado = false;
		kilometraje = km;
		calcularImporte();
	}
	
	public String consultarDatos(){
		return "[Matricula: "+matricula+", "+
				"Kilometraje: "+kilometraje+"km, "+
				"Alquilado: "+alquilado+", "+
				"Importe: "+importe+"€, ";
	}
	
	public abstract String consultarDatosPorTipo();
	
	public abstract double calcularImporte();

}
