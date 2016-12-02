package ejercicio4;

/**
 * Created by curso mañana on 28/11/2016.
 */
public class Rectangulo {
    Punto arribaIzq;
    Punto arribaDrch;
    Punto abajoIzq;
    Punto abajoDrch;
    float base;
    float altura;

    public Rectangulo(Punto arribaIzq, Punto arribaDrch, Punto abajoIzq, Punto abajoDrch) {
        this.arribaIzq = arribaIzq;
        this.arribaDrch = arribaDrch;
        this.abajoIzq = abajoIzq;
        this.abajoDrch = abajoDrch;
    }

    public Rectangulo(Punto arribaDrch) {
        this.arribaDrch=arribaDrch;
        arribaIzq=new Punto(0,arribaDrch.getCoordenadaY());
        abajoDrch=new Punto(arribaDrch.getCoordenadaX(),0);
        arribaIzq=new Punto(0,0);
    }

    public float calcularBase(){
        return -abajoIzq.getCoordenadaY()+arribaDrch.getCoordenadaY();
    }

    public float calcularAltura(){
        return -abajoIzq.getCoordenadaX()+arribaDrch.getCoordenadaX();
    }

    public float area(){
        return calcularBase()*calcularAltura();
    }
    public void escribir(){
        System.out.println("base: "+calcularBase()+"\naltura: "+calcularAltura()+"\narea:"+area());
    }
}
