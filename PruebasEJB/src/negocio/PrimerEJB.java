package negocio;

public class PrimerEJB implements PrimerEJBRemote{
    public PrimerEJB() {
    }
    public String saludo(String nombre){
        if(nombre==null){
            return "hola desconocido";
        }else{
            return "hola "+nombre;
        }
    }
}
