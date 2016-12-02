package orquesta;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class Violin extends Cuerda {
    @Override
    public String tocar() {
        String nombreDelInstrumento = "violin";
        return super.tocar()+ nombreDelInstrumento;
    }
}
