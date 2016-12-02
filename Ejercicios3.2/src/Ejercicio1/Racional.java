package Ejercicio1;

/**
 * Created by curso mañana on 25/11/2016.
 */
public class Racional {
    private int numerador; //el de arriba
    private int denominador; //el de abajo

    public Racional() {
        numerador = 0;
        denominador = 1;
    }

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public float sumar(int numerador, int denominador) {
        float suma;
        float totalDenominador = denominador * this.denominador;
        suma = ((this.numerador * denominador) + (this.denominador * numerador)) / totalDenominador;
        return suma;
    }

    public float restar(int numerador, int denominador) {
        float restar;
        float totalDenominador = denominador * this.denominador;
        restar = ((this.numerador * denominador) - (this.denominador * numerador)) / totalDenominador;
        return restar;
    }

    public float multiplicar(int numerador, int denominador) {
        float multiplicar;
        float totalDenominador = denominador * this.denominador;
        multiplicar = (numerador * this.numerador) / totalDenominador;
        return multiplicar;
    }

    public float dividir(int numerador, int denominador) {
        float dividir;
        dividir = this.numerador * denominador / ((float)this.denominador * numerador);
        return dividir;
    }

    public boolean comparacion(int numerador, int denominador) {
        if (numerador / denominador > this.numerador / this.denominador) return true;
        else return false;
    }

    public void escribir(int numerador, int denominador) {
        System.out.println("suma: " + sumar(numerador, denominador) + "\nresta: " + restar(numerador, denominador) + "\nmultiplicacion: " + multiplicar(numerador, denominador) + "\ndivision: " + dividir(numerador, denominador) + "\nes mayor la introducida por parametros?" + comparacion(numerador, denominador));
    }
}
