package Ejer2CarreraMetrosLisos;

public class Pistoletazo {
    synchronized void esperarPistoletazo(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized void darSalida(){
        notifyAll();
    }
}
