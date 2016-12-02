package EjerAbstract3;

import java.util.Scanner;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class Main {
    public static void main(String[] args){
        MenuCompania menu = new MenuCompania();
        boolean sigueEnElBucle = true;
        while(sigueEnElBucle){
            System.out.println(menu.showMenu());
            sigueEnElBucle=menu.seleccionar(introducirDato());
        }
    }

    private static int introducirDato() {
        try{
            Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        }catch(Exception e){
            System.out.println("eso no es una opcion");
        }
        return -1;
    }
}
