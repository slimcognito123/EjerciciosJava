package Ejercicios3;

/**
 * Created by curso mañana on 25/11/2016.
 * resultado : 9 9
 * resultado2 : 7 7
 */
public class Ejercicio3 {
        public static void main(String[] args) {
            Clase3 obj1 = new Clase3(7);
            Clase3 obj2 = new Clase3(9);
            obj2 = obj1;
            System.out.print(obj1.valorprop() + " ");
            System.out.print(obj2.valorprop() + " ");
        }
}
class Clase3 {
    int prop = 0;

    public Clase3(int valor) {
        prop = valor;
    }

    public int valorprop() {
        return prop;
    }
}