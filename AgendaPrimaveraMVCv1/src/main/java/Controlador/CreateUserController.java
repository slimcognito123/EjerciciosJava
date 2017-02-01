package Controlador;

import Beans.Usuario;
import Modelo.Business.UsuarioBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/createUser.do")
public class CreateUserController {

    @Autowired
    UsuarioBusiness usuarioBusiness;

    @RequestMapping(method = RequestMethod.POST)
    public String createUserForm(@RequestParam("usuario") String usuario, @RequestParam("password") String password, @RequestParam("password2") String password2, BindingResult bindingResult, Model model) {

        if (comprobarContrasenas(password, password2)) {
            if (comprobarUsuarioBD(usuario)) {
                Usuario user = new Usuario(usuario, password);
                usuarioBusiness.insertarUsuario(user);
            } else {
                bindingResult.rejectValue("errorCrearUsuario", "usuarioYaActivo");
            }
        } else {
            bindingResult.rejectValue("errorContrasenaConcordancia", "contrasenasNoConcuerdan");
        }
        if (bindingResult.hasErrors()) {
            return "crearUsuario";
        }
        return "index";
    }

    private boolean comprobarUsuarioBD(String usuario) {
        return !usuarioBusiness.buscarUsuarioRepetido(usuario);
    }

    private boolean comprobarContrasenas(String password, String password2) {
        return password.compareTo(password2) == 0;
    }

}
