package EjersTema2;

/**
 * Created by curso mañana on 25/11/2016.
 */
public class Ejercicio5 {
    public Ejercicio5(int numero) {
        int factor = 1;
        for (int i = 1; i <= numero; i++) {
            factor *= i;
        }
        System.out.println(factor);
    }

    public static void main(String[] args) {
        try {
            new Ejercicio5(Integer.parseInt(args[0]));
        } catch (Exception e) {
            System.out.println("introduce un numero entero de repeticiones");
        }
    }
}
