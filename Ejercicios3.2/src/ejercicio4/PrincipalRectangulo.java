package ejercicio4;

/**
 * Created by curso mañana on 28/11/2016.
 */
public class PrincipalRectangulo {
    Rectangulo rectangulo;
    Rectangulo rectangulo2;

    public PrincipalRectangulo(Punto arribaIzq,Punto arribaDrch,Punto abajoIzq,Punto abajoDrch){
        rectangulo=new Rectangulo(arribaIzq,arribaDrch,abajoIzq,abajoDrch);
        rectangulo2=new Rectangulo(arribaDrch);
        System.out.println("primer rectangulo--------------");
        rectangulo.escribir();
        System.out.println("segundo rectangulo-------------");
        rectangulo2.escribir();
        if(rectangulo.area()>rectangulo2.area()){
            System.out.println("el primer rectangulo es mas grande");
        }else{
            System.out.println("el segundo rectangulo es mas grande");
        }
    }
    public static void main(String[] args){
        Punto arribaIzq;
        Punto arribaDrch;
        Punto abajoIzq;
        Punto abajoDrch;
        try{
            int y= Integer.parseInt(args[1]);
            int x=Integer.parseInt(args[0]);
            int y2=Integer.parseInt(args[3]);
            int x2=Integer.parseInt(args[2]);
            arribaIzq=new Punto(x,y);
            arribaDrch=new Punto(x,y2);
            abajoIzq=new Punto(x2,y);
            abajoDrch=new Punto(x2,y2);
            new PrincipalRectangulo(arribaIzq,arribaDrch,abajoIzq,abajoDrch);
        }catch(Exception e){
            System.out.println("mete valores");
        }
    }
}
