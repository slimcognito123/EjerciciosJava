package ejercicio5;

public class InstrumentoViento extends Instrumento {

	public InstrumentoViento(String nombre) {
		super(nombre);
	}

	@Override
	public void tocar() {
		System.out.println("Estoy soplando el instrumento "+ nombre);
	}
	
	
}
