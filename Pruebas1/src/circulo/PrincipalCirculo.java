package circulo;

/**
 * Created by Patata kawaii on 27/11/2016.
 */
public class PrincipalCirculo {
    public PrincipalCirculo(int coordenadaX, int coordenadaY, float radio) {

        Circulo objCirculo = new Circulo();
        Circulo objCirculo2 = new Circulo(radio);
        Circulo objCirculo3 = new Circulo(coordenadaX,coordenadaY,radio);

        objCirculo.escribirResultados();
        objCirculo2.escribirResultados();
        objCirculo3.escribirResultados();

    }

    public static void main(String[] args) {
        try {
            new PrincipalCirculo(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Float.parseFloat(args[2]));
        }catch (Exception e){
            System.out.println("todo en numeros please");
        }
    }
}
