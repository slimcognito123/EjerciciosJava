package polinomio;

/**
 * Created by Patata kawaii on 26/11/2016.
 */
public class PrincipalPolinomio {
    public PrincipalPolinomio(int baseCuadrado, int baseElevado1, int baseSinElevar, double x) {
        Polinomio polinomio = new Polinomio(baseCuadrado,baseElevado1,baseSinElevar);
        polinomio.escribir(x);
    }

    public static void main(String[] args) {

        int elevado2;
        int elevado1;
        int sinElevar;
        double valorDeX;

        try {
            elevado2=Integer.parseInt(args[0]);
            elevado1=Integer.parseInt(args[1]);
            sinElevar=Integer.parseInt(args[2]);
            valorDeX= Double.parseDouble(args[3]);
            new PrincipalPolinomio(elevado2,elevado1,sinElevar,valorDeX);
        }catch (Exception e){
            System.out.printf("introduce todos los valores como numeros, solo la X puede ser decimal.");
        }
    }
}
