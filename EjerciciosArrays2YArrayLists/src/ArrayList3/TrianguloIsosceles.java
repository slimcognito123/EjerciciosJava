package ArrayList3;

/**
 * Created by curso mañana on 30/11/2016.
 */
public class TrianguloIsosceles {
    private float aristaLateral;
    private float aristaInferior;
    private float base;

    public float getAristaLateral() {
        return aristaLateral;
    }

    public void setAristaLateral(float aristaLateral) {
        this.aristaLateral = aristaLateral;
    }

    public float getAristaInferior() {
        return aristaInferior;
    }

    public void setAristaInferior(float aristaInferior) {
        this.aristaInferior = aristaInferior;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    private float altura;

    public TrianguloIsosceles(float aristaLateral, float aristaInferior) {
        this.aristaLateral = aristaLateral;
        this.aristaInferior = aristaInferior;
        this.base=aristaInferior/2;
        this.altura=this.calcularAltura(aristaLateral,this.base);
    }

    private float calcularAltura(float hipotenusa, float base) {
        return (float)Math.sqrt(Math.pow(hipotenusa,2)-Math.pow(base,2));
    }

    public float getPerimeter(){
        return aristaLateral*2+aristaInferior;
    }

    public float getArea(){
        return base*altura/2;
    }

    @Override
    public String toString() {
        return "TrianguloIsosceles{" +
                "aristaLateral=" + aristaLateral +
                ", aristaInferior=" + aristaInferior +
                ", base=" + base +
                ", altura=" + altura +
                '}';
    }
}
