package negocio;

public class NegocioPlus implements NegocioInter {
    private NegocioInter target= new Negocio();

    @Override
    public String ejecutar() {
        System.out.println("inicio de transaccion (Transaction.begin();)");
        System.out.println("creo un shocket");
        String salida= target.ejecutar();
        System.out.println("cierro transaccion (Trasaction.commit();)");

        return salida;
    }
}
