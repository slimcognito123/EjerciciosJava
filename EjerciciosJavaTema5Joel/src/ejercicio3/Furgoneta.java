package ejercicio3;

public class Furgoneta extends Vehiculo {
	private double capacidad;

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	public Furgoneta(String matricula, double kilometraje, boolean alquilado, double importe, double capacidad) {
		super(matricula, kilometraje, alquilado, importe);
		this.capacidad = capacidad;
	}

	@Override
	public double calcularImporte() {
		importe = 0.5*getKilometraje();
		return importe;
	}
	
	public String consultarDatosPorTipo(){
		return super.consultarDatos() + 
				"Capacidad: "+capacidad+"kg]";
	}

}
