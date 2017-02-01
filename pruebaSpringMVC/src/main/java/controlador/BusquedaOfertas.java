package controlador;

import Beans.BusquedaOferta;
import Beans.Oferta;
import Modelo.negocio.IGestionOfertas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/busquedaOfertas.do")
public class BusquedaOfertas {

    @Autowired
    IGestionOfertas gestionOfertas;

    @RequestMapping(method = RequestMethod.GET)
    public String rellenaFormulario(Model model){
        BusquedaOferta busquedaOferta = new BusquedaOferta();
        busquedaOferta.setNumeroNoches(2);
        busquedaOferta.setPrecio(70);
        model.addAttribute("busquedaOferta",busquedaOferta);
        return "busquedaOfertas";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String procesaFormulario(@ModelAttribute("busquedaOferta") BusquedaOferta busquedaOferta, BindingResult bindingResult, Model model){

        if (busquedaOferta.getPrecio()<0) {
            bindingResult.rejectValue("precio","negativo");
            return "busquedaOfertas";
        }

        if (bindingResult.hasErrors()){
            return "busquedaOfertas";
        }

        List<Oferta> ofertas = gestionOfertas.buscarOfertasPorPrecio(busquedaOferta);
        model.addAttribute("ofertas",ofertas);
        return "vistaOfertas";
    }
}
