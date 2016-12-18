package Procesos;

import Beans.Pescado;
import Beans.PezNormal;
import Beans.Tiburon;

import java.util.ArrayList;

public class Pecera {
    ArrayList<Pescado> listaPeces;
    Pescado[][] pecera = new Pescado[20][20];

    public Pecera() {
        inicialize();
    }

    private void inicialize() {
        listaPeces= new ArrayList<>();
        //crear hembras
        for (int i = 0; i < 50; i++) {
            listaPeces.add(new PezNormal(false));
        }
        //crear machos
        for (int i = 0; i < 50; i++) {
            listaPeces.add(new PezNormal(true));
        }
        for (int i = 0; i < 5; i++) {
            listaPeces.add(new Tiburon(false));
            listaPeces.add(new Tiburon(true));
        }
        for (Pescado pescado : listaPeces) {
            pecera[pescado.getX()][pescado.getY()]=pescado;
        }
    }
    public void movimientoEnLaPecera(){
        for (Pescado pescado : listaPeces) {
            pescado.start();
        }
    }

    private void comprobarColision() {

    }

    public static void main(String[] args) {
        Pecera pecera=new Pecera();
        pecera.mostrarPeces();
    }

    private void mostrarPeces() {
        for (Pescado pez : listaPeces) {
            System.out.println(pez.getClass()+" X:"+pez.getX()+" Y:"+pez.getY());
            pecera[pez.getX()][pez.getY()]=pez;
        }
    }
}
