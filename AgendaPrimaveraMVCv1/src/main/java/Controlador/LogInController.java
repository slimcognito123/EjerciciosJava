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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpSession;

/**
 * Created by Patata kawaii on 01/02/2017.
 */
@Controller
@RequestMapping("/login.do")
public class LogInController {
    @Autowired
    UsuarioBusiness usuarioBusiness;

    @RequestMapping(method = RequestMethod.POST)
    public String loginForm(@ModelAttribute("logUser") Usuario usuario, BindingResult bindingResult, Model model, HttpSession session) {
        if (usuarioBusiness.comprobarUser(usuario.getNombre(), usuario.getPassword())) {
            session.setAttribute("user", usuario);
            session.setMaxInactiveInterval(240);
            return "mainMenu";
        } else {
            bindingResult.rejectValue("errorLogin","errorLoginMensaje");
            return "index";
        }
    }

}
