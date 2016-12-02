package interfaceImpresion;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class ITFPositivo implements ITFImpresion {

    public ITFPositivo() {
    }

    @Override
    public void imprimir() {
        System.out.println("¡Que buen tiempo hace!");
    }
}
