package controlador;

import Beans.BusquedaOferta;
import Beans.Oferta;
import Modelo.negocio.IGestionOfertas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/ofertas.do")
public class controladorOfertas {

    @Autowired
    private IGestionOfertas gestionOfertas;

    @RequestMapping(method = RequestMethod.GET)
    public /*ModelAndView*/ String procesar(@RequestParam(value = "precio", required = false, defaultValue = "0") double precio, Model modelo) {

        List<Oferta> ofertas;
        ofertas = gestionOfertas.buscarOfertasPorPrecio(precio);

        //        ModelMap modelomapa=new ModelMap();

        modelo.addAttribute("ofertas",ofertas);

//        return new ModelAndView("vistaOfertas",modelomapa);
        return "vistaOfertas";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String procesarFormulario(BusquedaOferta busquedaOferta, Model modelo){
        List<Oferta> ofertas;
        ofertas = gestionOfertas.buscarOfertasPorPrecio(busquedaOferta);
        modelo.addAttribute("ofertas",ofertas);
        return "vistaOfertas";
    }
}
