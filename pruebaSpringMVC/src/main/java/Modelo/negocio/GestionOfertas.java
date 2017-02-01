package Modelo.negocio;

import Beans.BusquedaOferta;
import Beans.Oferta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestionOfertas implements IGestionOfertas {
    private ArrayList<Oferta> ofertas;

    public GestionOfertas() {
        crearOfertas();
    }

    @Override
    public List<Oferta> buscarOfertasPorPrecio(double precioMax) {
        ArrayList<Oferta> aux= new ArrayList<Oferta>();
        if(precioMax > 0) {
            for (Oferta oferta:ofertas){
                if (oferta.getPrecio()<precioMax){
                    aux.add(oferta);
                }
            }
        } else {
            aux = ofertas;
        }
        return aux;
    }

    @Override
    public List<Oferta> buscarOfertasPorPrecio(BusquedaOferta busquedaOferta) {
        ArrayList<Oferta> aux= new ArrayList<Oferta>();
        for (Oferta oferta : ofertas) {
            if (oferta.getPrecio()<busquedaOferta.getPrecio() && oferta.getNumeroNoches() == busquedaOferta.getNumeroNoches()){
                aux.add(oferta);
            }
        }
        return aux;
    }

    public void crearOfertas(){
        ofertas= new ArrayList<Oferta>();
        ofertas.add(new Oferta(50.21,2,"cacalavaca"));
        ofertas.add(new Oferta(60.21,2,"sdfsdaf"));
        ofertas.add(new Oferta(69.21,7,"vgsdasfd"));
        ofertas.add(new Oferta(900.21,3,"sdaf"));
        ofertas.add(new Oferta(3,5,"wwwwwwwwwwwwww"));
        ofertas.add(new Oferta(51,2,"lolollolololo"));
        ofertas.add(new Oferta(59.21,9,"dsfjijfios"));
        ofertas.add(new Oferta(32.02,10,"asdfsf"));
    }
}
