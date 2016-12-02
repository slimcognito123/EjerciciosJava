package orquesta;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class Cuerda implements Instrumento {
    @Override
    public String tocar() {
        return "Estoy rasgando el instrumento ";
    }
}
