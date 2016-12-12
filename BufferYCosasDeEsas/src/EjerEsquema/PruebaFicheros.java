package EjerEsquema;

/**
 * Created by Patata kawaii on 12/12/2016.
 */
public class PruebaFicheros {
    Teclado teclado;
    FicheroEscritura ficheroEscritura;
    FicheroLectura ficheroLectura;
    FicheroLectura ficheroLecturaBueno;

    public PruebaFicheros() {
        teclado=new Teclado();
        FicheroEscritura ficheroEscrituraBorrador = new FicheroEscritura("patata.txt", false);
        ficheroEscrituraBorrador.cerrar();
        ficheroEscritura = new FicheroEscritura("patata.txt",true);
        //ficheroLectura= new FicheroLectura("patatas.txt");
        System.out.println("escribe linea de texto");
        ficheroEscritura.escribirLinea(teclado.leerCadena());
        System.out.println("escribe otra linea de texto");
        ficheroEscritura.escribirLinea(teclado.leerCadena());
        System.out.println("escribe un entero");
        ficheroEscritura.escribirLinea(teclado.leerInt());
        System.out.println("escribe un decimal");
        ficheroEscritura.escribirLinea(teclado.leerDouble());
        ficheroEscritura.cerrar();
        ficheroLecturaBueno= new FicheroLectura("patata.txt");
        //System.out.println(ficheroLectura.leerCadena());
        System.out.println(ficheroLecturaBueno.leerLinea());//<-lo hace bien
        System.out.println(ficheroLecturaBueno.leerCadena());//<-lo hace bien
        System.out.println(ficheroLecturaBueno.leerCadena("patata"));//<-se queda atascado
    }

    public static void main(String[] args) {
        new PruebaFicheros();
    }
}
