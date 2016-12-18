package CarreraDeRelevos.Beans;

/**
 * Created by Patata kawaii on 18/12/2016.
 */
public class Relevo {
    public synchronized void esperarRelevo(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void darRelevo(){
        notify();
    }
}
