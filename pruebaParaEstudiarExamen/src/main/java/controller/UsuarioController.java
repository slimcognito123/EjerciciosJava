package controller;

import beans.Usuario;
import model.business.UsuarioBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

/**
 * Created by Patata kawaii on 05/02/2017.
 */
@Controller
public class UsuarioController {

    @Autowired
    UsuarioBusiness usuarioBusiness;

    @RequestMapping(value = "/crearUser.do",method = RequestMethod.POST)
    public String crearUsuario(Usuario usuario, HttpSession session){
        if(usuarioBusiness.comprobarUsuarioExistente(usuario.getNombreUsuario())){
            //si existe el usuario
            return "crearUsuario";
        }else{
            usuarioBusiness.insertarUsuario(usuario);
            session.setAttribute("usuario",usuario);
            return "redirect:buscarTodos.do";
        }
    }

    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String logueo(Usuario usuario, HttpSession session){
        if(usuarioBusiness.comprobarLogin(usuario)){
            session.setAttribute("usuario",usuario);
            return "redirect:buscarTodos.do";
        }else {
            return "index";
        }
    }

    @RequestMapping(value = "/logout.do",method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }
}
