package ejercicio3;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		//ALTA VEHICULOS
		Furgoneta f = new Furgoneta("F00001", 0.0, false, 0.0, 200.0);
		Moto m = new Moto("M00002", 0.0, false, 0.0, false);
		Coche c = new Coche("C00003", 0.0, false, 0.0, false);
		ArrayList<Vehiculo> lista = new ArrayList<>();
		lista.add(f);
		lista.add(m);
		lista.add(c);
		
		//MOSTRAR VEHICULOS
		System.out.println("NUEVOS VEHICULOS: ");
		for (Vehiculo vehiculo : lista) {
			System.out.println(vehiculo.consultarDatosPorTipo());
		}
		System.out.println("----------------------------");
		
		
		//ALQUILAR VEHICULOS
		for (Vehiculo vehiculo : lista) {
			if(vehiculo instanceof Moto){
				vehiculo.alquilar();
				((Moto) vehiculo).setCasco(true);
			}else if(vehiculo instanceof Coche){
				vehiculo.alquilar();
				((Coche) vehiculo).setExtra(true);
			}
		}
		
		//MOSTRAR VEHICULOS ALQUILADOS
		System.out.println("VEHICULOS ALQUILADOS: ");
		for (Vehiculo vehiculo : lista) {
			if(vehiculo.isAlquilado()){
				System.out.println(vehiculo.consultarDatosPorTipo());
			}
		}
		System.out.println("----------------------------");
		
		//DEVOLVER VEHICULOS
		for (Vehiculo vehiculo : lista) {
			if(vehiculo instanceof Moto){
				vehiculo.devolver(40.0);
				((Moto) vehiculo).setCasco(false);
			}
		}
		
		//MOSTRAR VEHICULOS DEVUELTOS
		System.out.println("VEHICULOS DEVUELTOS: ");
		for (Vehiculo vehiculo : lista) {
			if(!vehiculo.isAlquilado() && vehiculo.getKilometraje()>0){
				System.out.println(vehiculo.consultarDatosPorTipo());
			}
		}
		System.out.println("----------------------------");
		

	}

}
