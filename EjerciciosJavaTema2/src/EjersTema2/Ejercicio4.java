package EjersTema2;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by curso mañana on 25/11/2016.
 */
public class Ejercicio4 {

    public Ejercicio4(long numeroRepeticiones) {
        long numero1 = 1;
        long numero2 = 1;
        long aux;
        for (int i = 0; i < numeroRepeticiones; i++) {
            aux = numero1;
            numero1 = numero2;
            numero2 = numero1 + aux;
            System.out.println(aux + " ");
        }
    }

    public static void main(String[] args) {
        try {
            new Ejercicio4(Long.parseLong(args[0]));
        } catch (Exception e) {
            System.out.println("introduce un numero entero");
        }
    }
}
