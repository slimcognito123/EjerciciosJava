package polinomio;

/**
 * Created by Patata kawaii on 26/11/2016.
 */
public class Polinomio {
    int coeficiente1;
    int coeficiente2;
    int coeficiente3;
    double valorX;

    public Polinomio() {
        coeficiente1 = 0;
        coeficiente2 = 0;
        coeficiente3 = 0;
    }

    public Polinomio(int coeficiente1, int coeficiente2, int coeficiente3) {
        this.coeficiente1 = coeficiente1;
        this.coeficiente2 = coeficiente2;
        this.coeficiente3 = coeficiente3;
    }

    public int getCoeficiente1() {
        return coeficiente1;
    }

    public void setCoeficiente1(int coeficiente1) {
        this.coeficiente1 = coeficiente1;
    }

    public int getCoeficiente2() {
        return coeficiente2;
    }

    public void setCoeficiente2(int coeficiente2) {
        this.coeficiente2 = coeficiente2;
    }

    public int getCoeficiente3() {
        return coeficiente3;
    }

    public void setCoeficiente3(int coeficiente3) {
        this.coeficiente3 = coeficiente3;
    }

    public double calcularValor(double x) {
        valorX = x;
        return (Math.pow(coeficiente1, 2) * valorX) + (coeficiente2 * valorX) + (coeficiente3);
    }

    public void escribir() {
        System.out.println("resultado: " + calcularValor(valorX));
    }

    public void escribir(double x) {
        System.out.println("resultado: " + calcularValor(x));
    }

}
