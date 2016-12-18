package ConciertoConHilos.Beans.Instrumentos;

import ConciertoConHilos.Beans.Tipos.Viento;
import ConciertoConHilos.Procesos.Concierto;

/**
 * Created by Patata kawaii on 18/12/2016.
 */
public class Flauta implements Viento {
    public String TocarInstrumento(){
        return tocar()+"La Flauta";
    }

    @Override
    public void run() {
        System.out.println(TocarInstrumento());
        Concierto.batuta.pararConcierto();
        System.out.println(TocarInstrumento());
        System.out.println(TocarInstrumento());
        System.out.println(TocarInstrumento());
    }
}
