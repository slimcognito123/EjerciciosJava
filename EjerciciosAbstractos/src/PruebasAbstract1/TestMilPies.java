package PruebasAbstract1;

/**
 * Created by curso mañana on 01/12/2016.
 */
class TestMilpies{
    public static void main(String[] args){
        MilpiesEsquiador m = new MilpiesEsquiador();
    }
}
class Milpies{
    protected int numeroDePies;
    public Milpies(){
        numeroDePies = 1000;
        escribePies();
    }
    public void escribePies(){
        System.out.println("Un Milpiés o Cochinilla tiene"
                + numeroDePies+" pies");
    }
}
class MilpiesEsquiador extends Milpies{
    protected int PiesRotos;
    public MilpiesEsquiador(){
        PiesRotos = 100;
    }
    public void escribePies(){
        System.out.println("A un Milpiés esquiador le quedan "+(numeroDePies-PiesRotos)+" pies");
    }
}