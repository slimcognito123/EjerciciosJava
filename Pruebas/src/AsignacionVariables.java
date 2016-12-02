import jdk.internal.util.xml.impl.Input;

/**
 * Created by curso mañana on 24/11/2016.
 */
public class AsignacionVariables {
    public static void main(String[] args) {
        int a=5;
        int b=0;
        int c;
        b= a *3;
        c= a;
        a=a +6;
        b =a-c;
        System.out.println("La variable A contiene: "+a);
        System.out.println("La variable B contiene: "+b);
        System.out.println("La variable C contiene: "+c);
        muestraPI();
        for (long i = 0L; i< 9223372036854775807L;i++){
            System.out.println("nunca más");
        }
    }
    public static void muestraPI(){
        final double PI = 3.1415926536;
        System.out.println(PI);
    }

}
