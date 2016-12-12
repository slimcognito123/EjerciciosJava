package ejercicio3;

public class Coche extends Vehiculo {

	private boolean extra;

	public Coche(String matricula, double kilometraje, boolean alquilado, double importe, boolean extra) {
		super(matricula, kilometraje, alquilado, importe);
		this.extra = extra;
	}

	public boolean isExtra() {
		return extra;
	}

	public void setExtra(boolean extra) {
		this.extra = extra;
	}

	@Override
	public double calcularImporte() {
		importe = 0.4*getKilometraje();
		if(extra){
			importe += 20.0;
		}
		return importe;
	}
	
	public String consultarDatosPorTipo(){
		return super.consultarDatos() + 
				"Extras: "+extra+"]";
	}
}
