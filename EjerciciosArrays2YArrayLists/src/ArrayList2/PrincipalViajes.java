package ArrayList2;

import java.util.ArrayList;

/**
 * Created by curso mañana on 30/11/2016.
 */
public class PrincipalViajes {
    ArrayList<Viaje> listaViajes;
    public PrincipalViajes() {
        listaViajes= new ArrayList<>();
        listaViajes.add(new Viaje("Madrid","Lisboa",1000));
        listaViajes.add(new Viaje("Madrid","Dublin",2000));
        listaViajes.add(new Viaje("Madrid","Londres",1500));
        listaViajes.add(new Viaje("Londres","Lisboa",1500));
        listaViajes.add(new Viaje("Florencia","Lisboa",1423));
        listaViajes.add(new Viaje("Londres","Roma",3000));
        listaViajes.add(new Viaje("Roma","Florencia",500));
        listaViajes.add(new Viaje("Florencia","Venecia",750));
        listaViajes.add(new Viaje("Venecia","Madrid",1250));
        uniendoEscalas(listaViajes);
    }

    private void uniendoEscalas(ArrayList<Viaje> listaViajes) {
        for (int i = 1; i < listaViajes.size(); i++) {
            Viaje viaje= new Viaje();
            viaje=viaje.uneViaje(listaViajes.get(i-1),listaViajes.get(i));
            System.out.println("Escala entre: "+listaViajes.get(i-1).getOrigen()+"/"+listaViajes.get(i-1).getDestino()+" y "+listaViajes.get(i).getOrigen()+"/"+listaViajes.get(i).getDestino()+".\n Distancia de:"+viaje.getDistancia());
        }
    }

    public static void main(String[] args){
        new PrincipalViajes();
    }
}
