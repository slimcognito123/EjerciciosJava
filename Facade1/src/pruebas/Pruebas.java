package pruebas;

import negocio.NegocioInter;
import negocio.NegocioPlus;

public class Pruebas {
    public static void main(String[] args) {
        NegocioInter negocioInter = new NegocioPlus();
        System.out.println(negocioInter.ejecutar());
    }
}
