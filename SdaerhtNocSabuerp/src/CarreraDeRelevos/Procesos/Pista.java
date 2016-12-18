package CarreraDeRelevos.Procesos;

import CarreraDeRelevos.Beans.Corredor;
import CarreraDeRelevos.Beans.Relevo;

import java.util.ArrayList;

/**
 * Created by Patata kawaii on 18/12/2016.
 */
public class Pista {
    public static Relevo relevo = new Relevo();
    ArrayList<Thread> listaCorredores;
    public Pista() {
        listaCorredores= new ArrayList<Thread>();
        inicialize();
    }

    private void inicialize() {
        for (int i = 0; i < 4; i++) {
            listaCorredores.add(new Thread(new Corredor(""+i)));
        }
        for (Thread thread : listaCorredores) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Thread persona : listaCorredores) {
            persona.start();
        }
        relevo.darRelevo();
    }
}
