package ejercicio3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private ArrayList<Vehiculo> listaVehiculos;

	public Menu(){
		listaVehiculos = new ArrayList<Vehiculo>();
	}

	public ArrayList<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}
	public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	public double solicitarNumero(int max, String mensaje) {
		boolean isError = true;
		double numero = 0;
		do {
			try {
				System.out.println(mensaje);
				Scanner entrada = new Scanner(System.in);
				numero = entrada.nextInt();
				if (numero > 0 && numero <= max)
					isError = false;
			} catch (InputMismatchException e) {
				System.out.println("Error, no es un numero");
			}
		} while (isError);
		return numero;
	}
	
	public String solicitarCadena(String mensaje) {
		boolean isError = true;
		String resultado = "";
		do {
			System.out.println(mensaje);
			Scanner entrada = new Scanner(System.in);
			resultado = entrada.nextLine();
			if (resultado.length() > 3)
				isError = false;
		} while (isError);
		return resultado;
	}

	/*public void solicitarDatosVehiculo(){
		String matricula = solicitarCadena("Matrícula: ");
		double kilometraje = solicitarNumero(999999,"Kilometraje: ");
	}*/
	
	public void altaFurgoneta(){
		String matricula = solicitarCadena("Matrícula: ");
		double kilometraje = solicitarNumero(999999,"Kilometraje: ");
		double capacidad = solicitarNumero(999999,"Capacidad: ");
		Furgoneta f = new Furgoneta(matricula, kilometraje, false, 0.0, capacidad);
		listaVehiculos.add(f);
	}
	
	public void altaCoche(){
		String matricula = solicitarCadena("Matrícula: ");
		double kilometraje = solicitarNumero(999999,"Kilometraje: ");
		Coche c = new Coche(matricula, kilometraje, false, 0.0, false);
		listaVehiculos.add(c);
	}
	
	public void altaMoto(){
		String matricula = solicitarCadena("Matrícula: ");
		double kilometraje = solicitarNumero(999999,"Kilometraje: ");
		Coche m = new Coche(matricula, kilometraje, false, 0.0, false);
		listaVehiculos.add(m);
	}
	

	
	public void alquilar(){
		
	}
	
	public void mostrarMenuTipoVehiculo(){
		while (true) {
			System.out.println("******************");
			System.out.println("*   ELIGE TIPO   *");
			System.out.println("******************");
			System.out.println("* 1. FURGONETA   *");
			System.out.println("* 2. COCHE       *");
			System.out.println("* 3. MOTO        *");
			System.out.println("* 4. SALIR       *");
			System.out.println("******************");
			int opcion = (int) solicitarNumero(4, "Introduce una opción:");
			switch (opcion) {
			case 1: altaFurgoneta();break;
			case 2: altaCoche();break;
			case 3: altaMoto();break;
			case 4:
				System.exit(0);
			default:
				break;
			}
		}
	}
	
	public void mostrarMenu() {

		while (true) {
			System.out.println("***************************");
			System.out.println("*          MENU           *");
			System.out.println("***************************");
			System.out.println("* 1. ALTA VEHICULO        *");
			System.out.println("* 2. ALQUILAR VEHICULO    *");
			System.out.println("* 3. DEVOLVER VEHICULO    *");
			System.out.println("* 4. LISTAR VEHICULOS     *");
			System.out.println("* 5. SALIR                *");
			System.out.println("***************************");
			int opcion = (int) solicitarNumero(5, "Introduce una opción:");
			switch (opcion) {
			case 1: mostrarMenuTipoVehiculo();
			case 2: ;break;
			case 3: ;break;
			case 4: ;break;
			case 5:
				System.exit(0);
			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu m = new Menu();
		m.mostrarMenu();
	}

}
