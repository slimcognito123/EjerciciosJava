package ConciertoConHilos.Beans.Instrumentos;

import ConciertoConHilos.Beans.Tipos.Percusion;
import ConciertoConHilos.Procesos.Concierto;

/**
 * Created by Patata kawaii on 18/12/2016.
 */
public class Bateria implements Percusion{

    @Override
    public void run() {
        System.out.println(TocarInstrumento());
        Concierto.batuta.pararConcierto();
        System.out.println(TocarInstrumento());
        System.out.println(TocarInstrumento());
    }

    public String TocarInstrumento(){
        return tocar()+"la Bateria";
    }
}
