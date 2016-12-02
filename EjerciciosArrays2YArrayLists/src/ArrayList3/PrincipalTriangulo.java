package ArrayList3;

import java.util.ArrayList;

/**
 * Created by curso mañana on 30/11/2016.
 */
public class PrincipalTriangulo {

    private ArrayList<TrianguloIsosceles> tonta;

    public PrincipalTriangulo() {
        tonta= new ArrayList<>();
        tonta.add(new TrianguloIsosceles(3,2));
        tonta.add(new TrianguloIsosceles(7,3));
        tonta.add(new TrianguloIsosceles(2,1));
        tonta.add(new TrianguloIsosceles(3,7));
        TrianguloIsosceles trianguloIsosceles = new TrianguloIsosceles(0,0);
        for (TrianguloIsosceles trianguloLista : tonta) {
            if (trianguloLista.getArea()>trianguloIsosceles.getArea()){
                trianguloIsosceles=trianguloLista;
            }
        }
        System.out.println("Area mas grande:\n"+trianguloIsosceles.toString());
        trianguloIsosceles = new TrianguloIsosceles(99,99);
        for (TrianguloIsosceles trianguloLista : tonta) {
            if (trianguloLista.getPerimeter()<trianguloIsosceles.getPerimeter()){
                trianguloIsosceles=trianguloLista;
            }
        }
        System.out.println("Perimetro mas pequeño:\n"+trianguloIsosceles.toString());
        System.out.println("datos del tercer triangulo de la lista:\n"+tonta.get(2).toString());
        System.out.println("Mostrando todos los triangulos");
        for (TrianguloIsosceles trianguloLista : tonta) {
                System.out.println(trianguloLista.toString());
        }
    }








    public static void main(String[] args){
        new PrincipalTriangulo();
    }
}
