package Controlador;

import Beans.Usuario;
import Modelo.Business.AgendaBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/removePerson.do")
public class removeController {

    @Autowired
    private AgendaBusiness agendaBusiness;

    @RequestMapping(method = RequestMethod.POST)
    public String removePerson(@RequestParam("id") int id, HttpSession session) {
        if (session == null) {
            return "index";
        } else {
            Usuario usuario = (Usuario) session.getAttribute("user");
            System.out.println("\033[32m"+id);
            agendaBusiness.eliminarPersonaid(id, usuario.getNombre());
            return "redirect:search.do";
        }
    }
}
