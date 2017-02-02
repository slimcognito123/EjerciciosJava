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
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
@Controller
@RequestMapping("/search.do")
public class searchContactsController {

    @Autowired
    private AgendaBusiness agendaBusiness;

    private ArrayList<Contacto> list;

    @RequestMapping(method = RequestMethod.GET)
    protected String searchContacts(@SessionAttribute("mes") String mes, @SessionAttribute("user")Usuario usuario, Model modelo){
        System.out.println("estoy en buscar por mes " + mes);
        return buscarMes(mes, usuario, modelo);
    }

    @RequestMapping(method = RequestMethod.POST)
    protected String searchContactsByMonth(@RequestParam("mes") String mes, @SessionAttribute("user")Usuario usuario, Model modelo){
        System.out.println("estoy en buscar por mes " + mes);
        return buscarMes(mes, usuario, modelo);
    }

    private String buscarMes(String mes, @SessionAttribute("user") Usuario usuario, Model modelo) {
        if (mes == null || Objects.equals(mes, "%"))
            list = agendaBusiness.recuperarAgendaCompleta(usuario.getNombre());
        else list = agendaBusiness.recuperarAgendaPorMes(mes, usuario.getNombre());
        System.out.println(list + " lista");
        System.out.println(mes + " mes");
        modelo.addAttribute("contactos",list);
        return "mainMenu";
    }

}
