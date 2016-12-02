package orquesta;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class Viento implements Instrumento {
    @Override
    public String tocar() {
        return "Estoy soplando el instrumento ";
    }
}
