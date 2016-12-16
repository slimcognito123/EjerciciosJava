package Ejer1CarreraRelevos;

import java.util.Calendar;

public class Atleta extends Thread {
    private final String nombre;
    private double tiempoInicio;
    private double tiempoFin;

    public Atleta(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        Carrera.testigo.cogerTestigo();
        correr();
        System.out.println(nombre + " ha dado el testigo");
        darTestigo();
    }

    private void darTestigo() {
        Calendar calendar = Calendar.getInstance();
        this.tiempoFin = (double) calendar.getTimeInMillis() / 1000;
        Carrera.testigo.cambiarDeCorredor();
        double tiempoTotal = getTiempoTotal();
        System.out.println(nombre + ": " + tiempoTotal+" seg");
    }

    public double getTiempoTotal() {
        return this.tiempoFin - this.tiempoInicio;
    }

    private void correr() {
        Calendar calendar = Calendar.getInstance();
        this.tiempoInicio = (double) calendar.getTimeInMillis() / 1000;
        synchronized (Carrera.testigo) {
            Carrera.testigo.enMano(this.nombre);
        }
    }
}
