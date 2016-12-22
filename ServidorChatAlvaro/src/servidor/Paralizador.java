package servidor;

public class Paralizador {

    public synchronized void notificar(){
        notifyAll();
    }
    public synchronized void esperar(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
