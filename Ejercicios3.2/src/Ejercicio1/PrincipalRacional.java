package Ejercicio1;

/**
 * Created by curso mañana on 28/11/2016.
 */
public class PrincipalRacional {

    public static void main(String[] args) {
        try {
            Racional racional = new Racional(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            racional.escribir(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } catch (Exception e) {
            System.out.println("Introduce numeros enteros");
        }
    }
}
