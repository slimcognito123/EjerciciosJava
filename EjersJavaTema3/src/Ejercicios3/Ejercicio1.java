package Ejercicios3;

/**
 * Created by curso mañana on 25/11/2016.
 *
 * resultado : 24.3 y 7
 */
public class Ejercicio1 {
    public static void main(String[] args){
        Clase1 obj1=new Clase1();
        obj1.imprimir(24.3,5);
    }
}
class Clase1{
    private double valor=9.8;
    private int x=7;
    public void imprimir(double valor, int x){
        System.out.print(valor+" "+this.x);
    }
}