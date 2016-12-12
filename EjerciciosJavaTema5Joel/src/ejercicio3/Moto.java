package ejercicio3;

public class Moto extends Vehiculo {
	private boolean casco;

	public Moto(String matricula, double kilometraje, boolean alquilado, double importe, boolean casco) {
		super(matricula, kilometraje, alquilado, importe);
		this.casco = casco;
	}

	public boolean isCasco() {
		return casco;
	}

	public void setCasco(boolean casco) {
		this.casco = casco;
	}

	@Override
	public double calcularImporte() {
		importe = 0.6*getKilometraje();
		if(casco){
			importe += 10.0;
		}
		return importe;
	}
	
	public String consultarDatosPorTipo(){
		return super.consultarDatos() + 
				"Casco: "+casco+"]";
	}
	
	
}
