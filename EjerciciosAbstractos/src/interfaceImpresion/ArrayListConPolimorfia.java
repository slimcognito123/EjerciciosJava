package interfaceImpresion;

import java.util.ArrayList;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class ArrayListConPolimorfia {
    

    public ArrayListConPolimorfia() {
        ArrayList<ITFImpresion> alday = new ArrayList<>();
        alday.add(new ITFPositivo());
        alday.add(new ITFNegativo());
        for (ITFImpresion impresion : alday) {
            impresion.imprimir();
        }
    }
    public static void main(String[] args){
        new ArrayListConPolimorfia();
    }
}
