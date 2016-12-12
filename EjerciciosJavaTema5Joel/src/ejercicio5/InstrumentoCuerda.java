package ejercicio5;

public class InstrumentoCuerda extends Instrumento {
	
	public InstrumentoCuerda(String nombre) {
		super(nombre);
}

	@Override
	public void tocar() {
		System.out.println("Estoy rascando el instrumento "+ nombre);
	}
	
}
