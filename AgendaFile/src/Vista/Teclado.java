package Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {



    public static BufferedReader entrada =
            new BufferedReader(new InputStreamReader(System.in));

    public String leerCadena(){
        String cadena = "";
        try {
            cadena = new String(entrada.readLine());
        } catch (IOException e) {
            System.out.println("Error de E/S");
        }
        return cadena;
    }

    public String leerInt(){
        int entero = 0;
        boolean error = false;
        do {
            try {
                error = false;
                entero =Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException e1) {
                error = true;
                System.out.println("Error en el formato del numero, intentelo de nuevo.");
            } catch (IOException e) {
                System.out.println("Error de E/S");
            }
        } while (error);
        return String.valueOf(entero);
    }
    public String leerDouble(){
        Double doble =0.0;
        boolean error = false;
        do {
            try {
                error = false;
                doble =Double.parseDouble(entrada.readLine());
            } catch (NumberFormatException e1) {
                error = true;
                System.out.println("Error en el formato del numero, intentelo de nuevo.");
            } catch (IOException e) {
                System.out.println("Error de E/S");
            }
        }while(error);
        return String.valueOf(doble);
    }
}
