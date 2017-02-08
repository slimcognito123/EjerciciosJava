package Controlador;

import Beans.Contacto;
import Beans.Usuario;
import Modelo.Business.AgendaBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/createPerson.do")
public class AddPersonController {

    @Autowired
    @Qualifier("agendaBusiness")
    private AgendaBusiness business;

    @RequestMapping(method = RequestMethod.POST)
    public String addPerson(Contacto contacto, HttpSession session){
        Pattern expresion = Pattern.compile("^[9|6|7][0-9]{8}$");
        Usuario usuario= (Usuario) session.getAttribute("user");
        System.out.println("\033[39m"+ contacto.getApellidos()+" "+contacto.getTelefono());
        System.out.println(expresion.pattern());
        if (session==null)return "index";
        if (expresion.matches(expresion.pattern(), contacto.getTelefono())) {
            contacto.setUser(usuario.getNombre());
            business.anadirPersonaOnline(contacto);
            return "redirect:search.do";
        } else {
//            result.rejectValue("errorTelefonoMalPuesto", "msgTelefonoMalPuesto");
            System.out.println("\033[35mno lo crea");
            return "paginaAnadir";
        }
    }
}
