package cuentaNumeros1_100;

/**
 * Created by curso mañana on 28/11/2016.
 */
public class contarNumeros {
    public contarNumeros() {
        int[] alday=new int[100];
        for (int i=1;i<alday.length+1;i++){
            alday[i-1]=i;
        }
        for (int i=alday.length-1;i>=0;i--){
            System.out.println(alday[i]);
        }
    }

    public static void main(String[] args){
        new contarNumeros();
    }
}
