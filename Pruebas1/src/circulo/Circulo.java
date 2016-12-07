package circulo;

/**
 * Created by Patata kawaii on 27/11/2016.
 */
public class Circulo {
    private final double PI=3.1415926535897932384626433832795;
    private int coordenadaX;
    private int coordenadaY;
    private float radio;

    public Circulo() {
        coordenadaX = 0;
        coordenadaY = 0;
        radio = 0;
    }

    public Circulo(float radio) {
        coordenadaX = 0;
        coordenadaY = 0;
        this.radio = radio;
    }

    public Circulo(int coordenadaX, int coordenadaY, float radio) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.radio = radio;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public double calcularArea(){
        return PI*radio*radio;
    }
    public double calcularLongitud(){
        return PI*radio*2;
    }
    public String escribirResultados(){
        String salida="Area: "+calcularArea()+"\nLongitud: "+calcularLongitud();
        System.out.println(salida);
        return salida;
    }
}
