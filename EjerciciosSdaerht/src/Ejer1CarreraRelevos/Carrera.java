package Ejer1CarreraRelevos;

public class Carrera {
    public static final Testigo testigo = new Testigo();
    private Atleta atleta1;
    private Atleta atleta2;
    private Atleta atleta3;
    private Atleta atleta4;

    public Carrera() {
        inizialice();
        empezarCarrera();
    }

    private void empezarCarrera()  {
        atleta1.start();
        atleta2.start();
        atleta3.start();
        atleta4.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testigo.cambiarDeCorredor();
        try{
            atleta1.join();
            atleta2.join();
            atleta3.join();
            atleta4.join();
        }catch(Exception e){
            e.printStackTrace();
        }

        mostrarResultados();
    }

    private void mostrarResultados() {
        System.out.println("tiempo general:");
        System.out.println(atleta1.getTiempoTotal()+atleta2.getTiempoTotal()+atleta3.getTiempoTotal()+atleta4.getTiempoTotal());
    }

    private void inizialice() {
        atleta1= new Atleta("Sonic");
        atleta2= new Atleta("Knuckles");
        atleta3= new Atleta("Tails");
        atleta4= new Atleta("Batman");
    }
    public static void main(String[] args){
        new Carrera();
    }
}
