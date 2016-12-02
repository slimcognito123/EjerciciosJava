package EjersTema2;

/**
 * Created by curso mañana on 24/11/2016.
 */
public class Ejercicio1 {
    private boolean bisiesto;

    public Ejercicio1(int ano) {
        int numero = ano;
        if (comprobarAno(numero)) {
            System.out.println("año Bisiesto");
            setBisiesto(true);
        } else {
            System.out.println("año no Bisiesto");
            setBisiesto(false);
        }

    }

    public static void main(String[] args) {
        try {
            new Ejercicio1(Integer.parseInt(args[0]));
        } catch (Exception e) {
            System.out.println("eso no es un año! pon un año en numero");
        }

    }

    private static boolean comprobarAno(int ano) {
        if (ano % 400 == 0 || ano % 4 == 0 && ano % 100 != 0) return true;
        return false;
    }

    public void setBisiesto(boolean bisiesto) {
        this.bisiesto = bisiesto;
    }

    public boolean isBisiesto() {
        return bisiesto;
    }
}
