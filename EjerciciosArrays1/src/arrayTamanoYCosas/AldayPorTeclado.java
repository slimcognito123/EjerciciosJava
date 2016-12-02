package arrayTamanoYCosas;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by curso mañana on 28/11/2016.
 */
public class AldayPorTeclado {

    public AldayPorTeclado() {
        int tamano = 0;
        System.out.println("introduce longitud del array: ");
        boolean error;
        do {
            error = false;
            try {
                Scanner escaner = new Scanner(System.in);
                tamano = escaner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("introduce numero entero");
                error = true;
            }
        } while (error);
        int[] alday = new int[tamano];
        for (int i = 0; i < alday.length; i++) {
            alday[i] = (int) Math.floor(Math.random() * 300 + 1);
        }
        int numero = 0;
        System.out.println("introduce un numero a comprobar: ");
        do {
            error = false;
            try {
                Scanner escaner = new Scanner(System.in);
                numero = escaner.nextInt();
                if (numero > 9 || numero < 0) {
                    System.out.println("introduce entre 0 y 9");
                    error = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("introduce numero entero");
                error = true;
            }
        } while (error);
        int numeroComprobar;
        int contador = 0;
        for (int i = 0; i < alday.length; i++) {
            numeroComprobar = alday[i];
            if (numeroComprobar%10==numero) {
                contador++;
            }
        }
        int[] arrayNumeros = new int[contador];
        contador=0;
        for (int i = 0; i < alday.length; i++) {
            numeroComprobar = alday[i];
            if (numeroComprobar%10==numero) {
                arrayNumeros[contador]=numeroComprobar;
                contador++;
            }
        }
        for (int i = 0; i < alday.length; i++) {
            if (i%10==0){
                System.out.print("\n");
            }
            System.out.print(alday[i]+" ");
        }
        System.out.println("\n\n");
        for (int i = 0; i < arrayNumeros.length; i++) {
            if (i%10==0){
                System.out.print("\n");
            }
            System.out.print(arrayNumeros[i]+" ");
        }
    }

    public static void main(String[] args) {
        new AldayPorTeclado();
    }
}
