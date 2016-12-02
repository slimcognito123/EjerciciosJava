package orquesta;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class Flauta extends Viento {
    @Override
    public String tocar() {
        String nombreDelInstrumento = "flauta";
        return super.tocar()+ nombreDelInstrumento;
    }
}
