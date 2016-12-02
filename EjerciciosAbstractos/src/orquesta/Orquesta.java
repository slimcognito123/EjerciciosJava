package orquesta;

import sun.applet.Main;

import java.util.ArrayList;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class Orquesta {
    ArrayList<Instrumento> equipo;

    public Orquesta(ArrayList<Instrumento> equipo) {
        this.equipo = equipo;
        concierto();
    }

    private void concierto() {
        for (Instrumento instrumento : equipo) {
            afinar(instrumento);
        }
        System.out.println("EMPEZAMOS EL CONCIERTAZO");
        for (Instrumento instrumento : equipo) {
            System.out.println(instrumento.tocar());
        }
    }

    public static void afinar(Instrumento instrumento){
        System.out.println("Afinando..."+instrumento.tocar());
    }

    public static void main(String[] args){
        ArrayList<Instrumento> alday= new ArrayList<>();
        alday.add(new Violin());
        alday.add(new Bombo());
        alday.add(new Flauta());
        new Orquesta(alday);
    }
}
