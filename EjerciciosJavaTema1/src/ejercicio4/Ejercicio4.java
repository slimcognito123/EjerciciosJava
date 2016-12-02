package ejercicio4;

/**
 * Created by curso mañana on 24/11/2016.
 */
public class Ejercicio4 {
    public static void main(String[] args){
        try{
            float peana = Float.parseFloat(args[0]);
            float pulgaa = peana * 12;
            float yarda = pulgaa /36;
            float cm = pulgaa * 2.54f;
            float m = cm /100;
            System.out.println("pulgadas: "+ m);
            System.out.println("pie: "+args[0]);
            System.out.println("Yarda: "+yarda);
            System.out.println("cm: "+cm);
            System.out.println("metro: "+ m);
        }catch(Exception e) {
            System.out.println("niaro niaro niaro naaaa broooken champ");
        }
    }
}
