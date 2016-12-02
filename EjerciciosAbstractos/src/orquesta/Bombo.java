package orquesta;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class Bombo extends Percusion{
    @Override
    public String tocar() {
        String nombreDelInstrumento = "bombo";
        return super.tocar()+ nombreDelInstrumento;
    }
}
