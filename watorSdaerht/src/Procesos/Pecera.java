package Procesos;

import Beans.Pescado;
import Beans.PezNormal;
import Beans.Tiburon;

import java.util.ArrayList;

public class Pecera {
    ArrayList<Pescado> listaPeces;

    public Pecera() {
        inicialize();
    }

    private void inicialize() {
        listaPeces= new ArrayList<>();
        //crear hembras
        for (int i = 0; i < 50; i++) {
            listaPeces.add(new PezNormal(0));
        }
        //crear machos
        for (int i = 0; i < 50; i++) {
            listaPeces.add(new PezNormal(0));
        }
        for (int i = 0; i < 10; i++) {
            listaPeces.add(new Tiburon(Math.floor()));
        }
    }
}
