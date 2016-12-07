package rectangulo;

/**
 * Created by Patata kawaii on 27/11/2016.
 */
public class Rectangulo {
    Punto coordenadaIzqArriba;
    Punto coordenadaDrchArriba;
    Punto coordenadaIzqAbajo;
    Punto coordenadaDrchAbajo;

    public Rectangulo(Punto coordenadaIzqArriba, Punto coordenadaDrchArriba, Punto coordenadaIzqAbajo, Punto coordenadaDrchAbajo) {
        this.coordenadaIzqArriba = coordenadaIzqArriba;
        this.coordenadaDrchArriba = coordenadaDrchArriba;
        this.coordenadaIzqAbajo = coordenadaIzqAbajo;
        this.coordenadaDrchAbajo = coordenadaDrchAbajo;
    }

    public Rectangulo(Punto coordenadaIzqArriba, Punto coordenadaDrchArriba, Punto coordenadaDrchAbajo) {
        this.coordenadaIzqArriba = coordenadaIzqArriba;
        this.coordenadaDrchArriba = coordenadaDrchArriba;
        this.coordenadaDrchAbajo = coordenadaDrchAbajo;
        coordenadaIzqAbajo=new Punto(0,0);
    }

    public double calcularArea(){
        double lado1=Math.sqrt((Math.pow(coordenadaIzqArriba.getCoordenadaX()-coordenadaDrchArriba.getCoordenadaX(),2))+(Math.pow(coordenadaIzqArriba.getCoordenadaY()-coordenadaDrchArriba.getCoordenadaY(),2)));
        double lado2=Math.sqrt((Math.pow(coordenadaIzqArriba.getCoordenadaX()-coordenadaIzqAbajo.getCoordenadaX(),2))+(Math.pow(coordenadaIzqArriba.getCoordenadaY()-coordenadaIzqAbajo.getCoordenadaY(),2)));
        return lado1*lado2;
    }
    public void escribirResultado(){
        System.out.println("area: "+calcularArea());
    }
}
