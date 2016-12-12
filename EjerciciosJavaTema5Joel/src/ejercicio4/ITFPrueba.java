package ejercicio4;

import java.util.ArrayList;

public class ITFPrueba {

	public static void main(String[] args) {
		ITFImpresion itfpPositivo = new ITFPositivo();
		ITFImpresion itfpNegativo = new ITFNegativo();
		
		ArrayList<ITFImpresion> lista = new ArrayList<ITFImpresion>();
		lista.add(itfpPositivo);
		lista.add(itfpNegativo);
		
		for (ITFImpresion itf : lista) {
			itf.imprimir();
		}
	}

}
