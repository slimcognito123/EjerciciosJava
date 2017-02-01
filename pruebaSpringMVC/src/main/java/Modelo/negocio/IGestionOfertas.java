package Modelo.negocio;


import Beans.BusquedaOferta;
import Beans.Oferta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGestionOfertas {
    public List<Oferta> buscarOfertasPorPrecio(double precioMax);

    List<Oferta> buscarOfertasPorPrecio(BusquedaOferta busquedaOferta);
}
