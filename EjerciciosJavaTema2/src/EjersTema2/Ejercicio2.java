package EjersTema2;

/**
 * Created by curso mañana on 25/11/2016.
 */
public class Ejercicio2 {
    private Ejercicio1 comprobador;

    public Ejercicio2(int dia, int mes, int ano) {
        comprobador = new Ejercicio1(ano);
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (dia < 1 || dia > 31) {
                    System.out.println("dia no valido.");
                } else if (dia == 31) {
                    if (mes == 12) {
                        mes = 1;
                        dia = 1;
                        ano++;
                        System.out.println("FELIZ AÑO NUEVOOOOO!!!!");
                    } else {
                        dia = 1;
                        mes++;
                    }
                } else {
                    dia++;
                }
                break;
            case 2:
                if (dia > 28 && !comprobador.isBisiesto() || dia > 29 && comprobador.isBisiesto() || dia < 1) {
                    System.out.println("dia no valido.");
                } else if (dia == 28 && !comprobador.isBisiesto() || dia == 29 && comprobador.isBisiesto()) {
                    mes++;
                    dia = 1;
                } else {
                    dia++;
                }
                break;
            default:
                if (dia < 0 || dia > 30) {
                    System.out.println("dia no valido.");
                } else if (dia == 30) {
                    dia = 1;
                    mes++;
                } else {
                    dia++;
                }
                break;
        }
        System.out.println(dia + "/" + mes + "/" + ano);

    }

    public static void main(String[] args) {
        try {
            int dia = Integer.parseInt(args[0]);
            int mes = Integer.parseInt(args[1]);
            int ano = Integer.parseInt(args[2]);
            new Ejercicio2(dia, mes, ano);
        } catch (Exception e) {
            System.out.println("dia mes y año tienen que ser numeros");
        }
    }

}
