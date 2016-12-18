package ConciertoConHilos.Beans.Instrumentos;

import ConciertoConHilos.Beans.Tipos.Cuerda;
import ConciertoConHilos.Procesos.Concierto;

/**
 * Created by Patata kawaii on 18/12/2016.
 */
public class Guitarra implements Cuerda {

    public String TocarInstrumento(){
        return tocar()+"la Guitarra";
    }

    @Override
    public void run() {
        System.out.println(TocarInstrumento());
        Concierto.batuta.pararConcierto();
        System.out.println(TocarInstrumento());
        System.out.println(TocarInstrumento());
    }
}
