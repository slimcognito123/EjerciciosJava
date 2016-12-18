package ConciertoConHilos.Beans.Director;

/**
 * Created by Patata kawaii on 18/12/2016.
 */
public class Batuta {
    public synchronized void pararConcierto(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void reanudadConcierto(){
        notifyAll();
    }
}
