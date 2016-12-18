package CarreraDeRelevos.Beans;

import CarreraDeRelevos.Procesos.Pista;

import java.util.Calendar;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Created by Patata kawaii on 18/12/2016.
 */
public class Corredor extends Persona implements Runnable{
    private long tiempoInicio;
    private long tiempoFin;
    private long tiempoTotal;

    public Corredor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("el corredor "+nombre+" esta listo");
        Pista.relevo.esperarRelevo();
        System.out.println("empieza a correr el corredor "+nombre);
        Calendar calendar = Calendar.getInstance();
        tiempoInicio=calendar.getTimeInMillis()/1000;
        try {
            sleep(new Random().nextInt(11001-9000)+9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        calendar = Calendar.getInstance();
        tiempoFin=calendar.getTimeInMillis()/1000;
        Pista.relevo.darRelevo();
        System.out.println("el corredor "+nombre+" ha dado el relevo");
        tiempoTotal= -tiempoInicio + tiempoFin;
        System.out.println("marca del corredor "+nombre+": "+tiempoTotal);
    }

    public long getTiempoTotal() {
        return tiempoTotal;
    }
}
