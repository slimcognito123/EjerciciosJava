package interfaceImpresion;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class ITFNegativo implements ITFImpresion {
    public ITFNegativo() {
    }

    @Override
    public void imprimir() {
        System.out.println("¡Odio los lunes!");
    }
}
