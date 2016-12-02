package arrayAleatorios;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by curso mañana on 28/11/2016.
 */
public class arrayAleatorios {

    public arrayAleatorios() {
        int[] alday = new int[10];
        for (int i = 0; i < alday.length; i++) {
            alday[i] = (int) Math.floor(Math.random()*100);
        }
        boolean error;
        int numero;
        do {
            error = false;
            try {
                Scanner escaner = new Scanner(System.in);
                numero = escaner.nextInt();
                System.out.println(alday[numero]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("numero fuera de rango");
                error = true;
            } catch (InputMismatchException e) {
                System.out.println("introduce numero entero");
                error = true;
            }
        } while (error);

    }

    public static void main(String[] args) {
        new arrayAleatorios();
    }
}
