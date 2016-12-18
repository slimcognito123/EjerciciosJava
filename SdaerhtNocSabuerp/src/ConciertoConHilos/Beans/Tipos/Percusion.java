package ConciertoConHilos.Beans.Tipos;

/**
 * Created by Patata kawaii on 18/12/2016.
 */
public interface Percusion extends Runnable {
    public default String tocar() {
        return "Estoy aporreando...";
    }
}
