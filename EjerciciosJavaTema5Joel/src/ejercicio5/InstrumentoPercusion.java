package ejercicio5;

public class InstrumentoPercusion extends Instrumento {

	public InstrumentoPercusion(String nombre) {
		super(nombre);
	}

	@Override
	public void tocar() {
		System.out.println("Estoy golpeando el instrumento "+ nombre);
	}
}
