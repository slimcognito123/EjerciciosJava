package Controlador;

import Beans.Contacto;
import Beans.Usuario;
import Modelo.Business.AgendaBusiness;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/modifyContact.do")
public class ModifyContactController {

    @Autowired
    private AgendaBusiness controller;


    @RequestMapping(method = RequestMethod.POST)
    public String modifyContact(@RequestParam("id") ObjectId id, Contacto contacto, HttpSession session) {
        if (session == null) {
            return "index";
        } else {
            Usuario usuario = (Usuario) session.getAttribute("user");
            Pattern expresion = Pattern.compile("^[9|6|7][0-9]{8}$");

            if (expresion.matches(expresion.pattern(), contacto.getTelefono())) {
                contacto.setUser(usuario.getNombre());
                contacto.set_id(id);
                controller.modificarPersona(contacto);
                return "redirect: search.do";
            } else {
//                bindingResult.rejectValue("TelefonoMalPuesto","msgTelefonoMalPuesto");
                return "PantallaModificar";
            }
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String sendToModify(@RequestParam("_id") ObjectId id, HttpSession session) {

        Contacto contacto = controller.recuperarPersona(id);
        session.setAttribute("contacto", contacto);

        return "PantallaModificar";
    }

}