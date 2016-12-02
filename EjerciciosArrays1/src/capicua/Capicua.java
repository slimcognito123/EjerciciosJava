package capicua;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by curso mañana on 29/11/2016.
 */
public class Capicua {
    public Capicua() {
        boolean error;
        int numero = 0;
        do {
            error = false;
            try {
                Scanner scan = new Scanner(System.in);
                numero = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("mete un numero");
                error = true;
            }

        } while (error);
        char[] cadena = String.valueOf(numero).toCharArray();
        boolean isCapicua = true;
        for (int i = 0; i < cadena.length / 2 && isCapicua; i++) {
            if (cadena[i] != cadena[cadena.length - i - 1]) {
                isCapicua = false;
            }
        }
        System.out.println("es capicua?" + isCapicua);
    }

    public static void main(String[] args) {
        new Capicua();
    }
}
