package ConciertoConHilos.Procesos;

import ConciertoConHilos.Beans.Director.Batuta;
import ConciertoConHilos.Beans.Instrumentos.Bateria;
import ConciertoConHilos.Beans.Instrumentos.Flauta;
import ConciertoConHilos.Beans.Instrumentos.Guitarra;
import ConciertoConHilos.Beans.Tipos.Cuerda;
import ConciertoConHilos.Beans.Tipos.Percusion;
import ConciertoConHilos.Beans.Tipos.Viento;

import static java.lang.Thread.sleep;

/**
 * Created by Patata kawaii on 18/12/2016.
 */
public class Concierto {
    public static Batuta batuta = new Batuta();

    Viento flauta;
    Thread hiloGuitarra;
    Cuerda guitarra;
    Thread hiloFlauta;
    Thread hiloBateria;
    Percusion bateria;
    public Concierto() {
        inicialize();
        afinar();
        empezarConcierto();
    }

    private void afinar() {
        hiloGuitarra = new Thread(guitarra);
        hiloFlauta = new Thread(flauta);
        hiloBateria = new Thread(bateria);
        System.out.println("afinando");

        hiloGuitarra.start();
        hiloFlauta.start();
        hiloBateria.start();
    }

    private void empezarConcierto() {
        System.out.println("empieza el conciertazo");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        batuta.reanudadConcierto();
    }

    private void inicialize() {
        guitarra = new Guitarra();
        flauta = new Flauta();
        bateria= new Bateria();
    }
}
