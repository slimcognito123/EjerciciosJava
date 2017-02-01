package Controlador;

import Beans.Usuario;
import Modelo.Business.UsuarioBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/busquedaOfertas.do")
public class CreateUserController {

    @Autowired
    UsuarioBusiness usuarioBusiness;

    @RequestMapping(method = RequestMethod.POST)
    public String procesaFormulario(@ModelAttribute("Usuario") Usuario usuario, BindingResult bindingResult, Model model) {
//
//        if (busquedaOferta.getPrecio() < 0) {
//            bindingResult.rejectValue("precio", "negativo");
//            return "busquedaOfertas";
//        }
//
//        if (bindingResult.hasErrors()) {
//            return "busquedaOfertas";
//        }
//
//        List<Oferta> ofertas = gestionOfertas.buscarOfertasPorPrecio(busquedaOferta);
//        model.addAttribute("ofertas", ofertas);
        if(comprobarUsuarioValido()){
            if (comprobarContrasenas(password, password2)) {
                if (comprobarUsuarioBD(usuario)) {
                    Usuario user = new Usuario(usuario, password);
//                    usuarioBusiness = new UsuarioDAOJPA();
                    ServletContext sc = getServletContext();
                    WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
                    UsuarioBusiness usuarioBusiness = (UsuarioBusiness) wac.getBean("usuarioBusiness");
                    usuarioBusiness.insertarUsuario(user);
                    response.sendRedirect("index.jsp?creacionCorrecta='ok'");
                } else {
                    bindingResult.rejectValue("errorCrearUsuario", "usuarioYaActivo");
                }
            } else {
                bindingResult.rejectValue("ErrorCrearUsuario", "contrasenasNoConcuerdan");
            }
        }else{
            bindingResult.rejectValue("ErrorCrearUsuario", "negativo");
        }
        if (bindingResult.hasErrors()) {
           return "crearUsuario";
        }
        return "index";
    }

    private boolean comprobarUsuarioValido() {


    }
}
