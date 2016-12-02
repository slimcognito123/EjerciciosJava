package ejercicio2;

/**
 * Created by curso mañana on 24/11/2016.
 */
public class Ejercicio2 {
    final static float EARTH_GRAVITY =  9.8f;
    final static float MOON_GRAVITY = EARTH_GRAVITY*17/100;
    public static void main(String[] args){

        System.out.println((Float.parseFloat(args[0])/EARTH_GRAVITY)*MOON_GRAVITY);
    }
}