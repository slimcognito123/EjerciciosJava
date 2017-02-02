package Controlador;

import Beans.Contacto;
import Beans.Usuario;
import Modelo.Business.AgendaBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/modifyContact.do")
public class ModifyContactController {

    @Autowired
    private
    AgendaBusiness controller;


    @RequestMapping(method = RequestMethod.POST)
    public String modifyContact(@RequestParam("id") String id, Contacto contacto, HttpSession session) {
        if (session == null) {
            return "index";
        } else {
            Usuario usuario = (Usuario) session.getAttribute("user");
            Pattern expresion = Pattern.compile("^[9|6|7][0-9]{8}$");

            if (expresion.matches(expresion.pattern(), contacto.getTelefono())) {
                contacto.setUser(usuario.getNombre());
                contacto.setId(Integer.parseInt(id));
                controller.modificarPersona(contacto);
                return "redirect: search.do";
            } else {
//                bindingResult.rejectValue("TelefonoMalPuesto","msgTelefonoMalPuesto");
                return "PantallaModificar";
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String sendToModify(@RequestParam("id") int id, HttpSession session) {

        Contacto contacto = controller.recuperarPersona(id);
        session.setAttribute("contacto", contacto);

        return "PantallaModificar";
    }

}