package Ejer2CarreraMetrosLisos;

public class Carrera {
    public static Pistoletazo pistoletazo= new Pistoletazo();
    private Corredor corredor1;
    private Corredor corredor2;
    private Corredor corredor3;
    private Corredor corredor4;
    private Corredor corredor5;
    private Corredor corredor6;
    private Corredor corredor7;
    private Corredor corredor8;

    public Carrera() {
        inicialize();
        corredoresPreparados();
        salida();
        correr();
    }

    private void correr() {
        pistoletazo.darSalida();
    }

    private void corredoresPreparados() {
        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
        corredor5.start();
        corredor6.start();
        corredor7.start();
        corredor8.start();
    }

    private void salida() {
        mensajes("Preparados!!");
        mensajes("Listos!!");
        mensajes("YA!!");
    }

    private void mensajes(String mensaje) {
        System.out.println(mensaje);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void inicialize() {
        corredor1=new Corredor(1);
        corredor2=new Corredor(2);
        corredor3=new Corredor(3);
        corredor4=new Corredor(4);
        corredor5=new Corredor(5);
        corredor6=new Corredor(6);
        corredor7=new Corredor(7);
        corredor8=new Corredor(69);
    }
    public static void main(String[] args){
        new Carrera();
    }
}
