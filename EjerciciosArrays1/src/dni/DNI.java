package dni;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by curso mañana on 29/11/2016.
 */
public class DNI {
    public DNI() {
        System.out.println("comprobador de dni, introduce solo los numeros");
        boolean error;
        String dni;
        do {
            error = false;
            Scanner scan = new Scanner(System.in);
             dni= scan.nextLine();
            if (dni.length()!=8){
                System.out.println("longitud del DNI incorrecta");
                error=true;
            }
            char[] dni2 = dni.toCharArray();
            for (int i = 0; i < dni.length(); i++) {
                    if ('0'>dni2[i]||'9'<dni2[i]){
                        error=true;
                        System.out.println("dni incorrecto");
                    }
            }
        } while (error);

        int letra = Integer.parseInt(dni)%23;
        char[] letrasDNI = {'T', 'R', 'W','A', 'G', 'M','Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S','Q','V', 'H', 'L', 'C', 'K', 'E'};
        System.out.println(dni+""+letrasDNI[letra]);
    }
    public static void main(String[] args){
        new DNI();
    }
}
