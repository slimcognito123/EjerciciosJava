package ejercicio5;

import java.util.ArrayList;

public class Orquesta {
	private ArrayList<Instrumento> lista;
	
	public Orquesta(ArrayList<Instrumento> lista){
		this.lista = lista;
	}

	public ArrayList<Instrumento> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Instrumento> lista) {
		this.lista = lista;
	}
	
	public static void afinar(Instrumento ins){
		System.out.print("Afinando...");
		ins.tocar();
		
	}
}
