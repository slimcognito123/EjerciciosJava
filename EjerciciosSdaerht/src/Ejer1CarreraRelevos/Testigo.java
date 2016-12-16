package Ejer1CarreraRelevos;

import static java.lang.Thread.sleep;

public class Testigo {
    public Testigo() {
    }
    void enMano(String nombre){
        try {
            System.out.println(nombre+" tiene el testigo");
            long tiempoDeLaCarrera = (long) Math.floor(Math.random() *(9000 - 11001)+11001);
            sleep(tiempoDeLaCarrera);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized void cambiarDeCorredor(){
        notify();
    }

    synchronized void cogerTestigo(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
