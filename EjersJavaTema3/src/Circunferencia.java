/**
 * Created by curso mañana on 25/11/2016.
 */
public class Circunferencia {
    private double x, y, radio;

    public Circunferencia() {
        this.x = 0;
        this.y = 0;
        this.radio = 0;
    }

    public Circunferencia(double cx, double cy, double r) {
        x = cx;
        y = cy;
        radio = r;
    }

    public void ponRadio(double r) {
        radio = r;
    }

    public double longitud() {
        return 2 * Math.PI * radio;
    }
}
