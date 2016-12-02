import java.util.InputMismatchException;
import java.util.Scanner;

public class Aleatorios {

	public static void main(String[] args) {
		Aleatorios a = new Aleatorios();
		a.mostrar();
		

	}

	public void mostrar(){
		//Crear array con tamaño introducido por el usuario
		int tamano = solicitarNumero("Introduce el tamaño del array");
		int arrayNumeros[] = new int[tamano];
	for (int i = 0; i < arrayNumeros.length; i++) {
		arrayNumeros[i] = (int)Math.floor(Math.random()*300);
		 System.out.print("["+arrayNumeros[i] +"]");
	}	
	System.out.println();
	//Solicitar ultimo digito
	   int recibido = solicitarNumero("Introduce el ultimo digito");
	   int arrayNumeros2[] = new int[tamano];
	   int j = 0;
	   //Creación del nuevo array con los elementos acabados en el ultim digito
	   for (int i = 0; i < arrayNumeros.length; i++) {
		   
		   if(arrayNumeros[i]%10 == recibido){
			   arrayNumeros2[j] = arrayNumeros[i];
			   j++;   
		   }
	}
	   
	   //recorro el nuevo array para mostrarlo
	   for (int i = 0; i < j; i++) {
		   System.out.print("["+arrayNumeros2[i] +"]");		
	}
	   
	}
	
	public int solicitarNumero(String mensaje){
		boolean isError=true;
		int numero=0;
		do{
		try {
		Scanner entrada = new Scanner(System.in);
		System.out.println(mensaje);
		numero = entrada.nextInt();
		isError=false;
		}
		catch (InputMismatchException e){
			System.out.println("Error, no es un numero");
					}
		}while(isError);
		return numero;
		}
		
	
}
