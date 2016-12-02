package histograma;

import java.lang.reflect.Array;

/**
 * Created by curso mañana on 29/11/2016.
 */
public class Histograma {
    public Histograma() {
        int[] numeros= new int[11];
        int[] aleatorios=new int [100];
        for (int i = 0; i < 100; i++) {
            aleatorios[i]=(int)Math.floor(Math.random()*11);
            numeros[aleatorios[i]]++;
        }
        for (int i=0; i<11;i++){
            System.out.print(i+": ");
            for (int j = 0; j < numeros[i]; j++) {
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args){
        new Histograma();
    }
}
