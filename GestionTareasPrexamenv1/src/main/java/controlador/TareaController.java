package controlador;

import beans.Tarea;
import beans.Usuario;
import modelo.Business.TareaBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class TareaController {

    @Autowired
    private TareaBusiness tareaBusiness;

    @RequestMapping(value = "/buscarTodos.do", method = RequestMethod.GET)
    public String recuperarTodasLasTareas(Model model, HttpSession session){
        if (session==null) return "index";
        model.addAttribute("tareasVisibles",tareaBusiness.recuperarTodasLasTareas());
        return "mainMenu";
    }

    @RequestMapping(value = "/buscarEstado.do", method = RequestMethod.GET)
    public String recuperarPorEstado(String estado,Model model,HttpSession session){
        if (session==null) return "index";
        System.out.println(estado);
        model.addAttribute("tareasVisibles", tareaBusiness.recuperarPorEstado(Integer.parseInt(estado)));
        return "mainMenu";
    }
    @RequestMapping(value = "/crearTarea.do",method = RequestMethod.POST)
    public String crearTarea(Tarea tarea, HttpSession session){
        if (session==null) return "index";
        tareaBusiness.crearTarea(tarea);
        return "redirect:buscarTodos.do";
    }
    @RequestMapping(value = "/actualizar.do",method = RequestMethod.POST)
    public String actualizarTarea(Tarea tarea, HttpSession session){
        if(session==null) return "index";
        Usuario usuario= (Usuario) session.getAttribute("usuario");
        tarea.setRealizada(true);
        tarea.setFechaRealizacion(String.valueOf(LocalDate.now()));
        tarea.setUsuarioRealiza(usuario);
        tareaBusiness.actualizarTarea(tarea);
        return "redirect:/buscarTodos.do";
    }
}
