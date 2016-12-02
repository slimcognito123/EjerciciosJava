package ArrayList2;

/**
 * Created by curso mañana on 30/11/2016.
 */
public class Viaje {
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    private String origen;
    private String destino;
    private double distancia;

    public Viaje() {
        this.origen = "";
        this.destino = "";
        this.distancia = -1;
    }

    public Viaje(String origen, String destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Viaje uneViaje(Viaje ida, Viaje vuelta){
        Viaje union;
        if(ida.getDestino().compareTo(vuelta.getOrigen())==0){
            union = new Viaje(ida.getOrigen(),vuelta.getDestino(),ida.getDistancia()+vuelta.getDistancia());
        }else{
            union = new Viaje(ida.getOrigen(),vuelta.getDestino(),-1);
        }
        return union;
    }
}
