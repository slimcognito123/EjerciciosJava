package Ejer2CarreraMetrosLisos;

import java.util.Calendar;

public class Corredor extends Thread {
    private int dorsal;
    private double tiempoFin;
    private double tiempoInicio;

    public Corredor(int dorsal) {
        this.dorsal = dorsal;
    }

    @Override
    public void run() {
        try {
            //System.out.println("el dorsal numero "+dorsal+" esta en sus marcas");
            this.tiempoInicio=cogerSegundos();
            Carrera.pistoletazo.esperarPistoletazo();
            long tiempoDeLaCarrera = (long) Math.floor(Math.random() * (9000 - 11001) + 11001);
            sleep(tiempoDeLaCarrera);
            System.out.println("ha llegado el dorsal "+dorsal);
            this.tiempoFin=cogerSegundos();
            System.out.println("tiempo total:"+(tiempoFin-tiempoInicio));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double cogerSegundos() {
        Calendar calendar = Calendar.getInstance();
         return (double)calendar.getTimeInMillis() / 1000;
    }
}
