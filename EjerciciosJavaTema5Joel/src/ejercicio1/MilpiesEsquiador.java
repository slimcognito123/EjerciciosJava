package ejercicio1;

public class MilpiesEsquiador extends Milpies {
	protected int PiesRotos;

	public MilpiesEsquiador() {
		PiesRotos = 100;
	}

	public void escribePies(){
	System.out.println("A un Milpiés esquiador le quedan "+(numeroDePies-PiesRotos)+" pies");
	}
}
