package ejercicio5;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		InstrumentoViento flauta = new InstrumentoViento("flauta");
		InstrumentoCuerda violin = new InstrumentoCuerda("violín");
		InstrumentoPercusion bombo = new InstrumentoPercusion("bombo");
		
		ArrayList<Instrumento> lista = new ArrayList<Instrumento>();
		lista.add(flauta);
		lista.add(violin);
		lista.add(bombo);
		
		Orquesta orquesta = new Orquesta(lista);
		for (Instrumento instrumento : lista) {
			Orquesta.afinar(instrumento);
		}
		
		System.out.println("EMPEZAMOS EL CONCIERTAZO");
		for (Instrumento instrumento : lista) {
			instrumento.tocar();
		}
		
	}

}
