
import java.io.*;

public class Teclado {
    /**
     * variable de clase asignada a la entrada estándar del sistema
     */
    public static BufferedReader entrada =
            new BufferedReader(new InputStreamReader(System.in));

    /**
     * lee una cadena desde la entrada estándar
     *
     * @return cadena de tipo String
     */
    public static String leerString() {
        String cadena = "";
        try {
            cadena = new String(entrada.readLine());
        } catch (IOException e) {
            System.out.println("Error de E/S");
        }
        return cadena;
    }

    public static int leerInt() {
        int entero = 0;
        boolean error = false;
        do {
            try {
                error = false;
                entero = Integer.valueOf(entrada.readLine()).intValue();
            } catch (NumberFormatException e1) {
                error = true;
                System.out.println("Error en el formato del numero, intentelo de nuevo.");
            } catch (IOException e) {
                System.out.println("Error de E/S");
            }
        } while (error);
        return entero;
    }
} // final de la clase Teclado
