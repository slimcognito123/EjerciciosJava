package controlador;

import beans.Usuario;
import modelo.business.UsuarioBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UsuarioBusiness usuarioBusiness;

    @RequestMapping(value = "/createUser.do", method = RequestMethod.POST)
    public String crearUsuario(Usuario usuario, HttpSession session) {
        if (usuarioBusiness.comprobarUsuarioExistente(usuario.getNombreUsuario())) {
            //si existe el usuario
            return "crearUsuario";
        } else {
            usuario.setEstado("Soy nuevo en la app, holi ^^");
            usuarioBusiness.insertarUsuario(usuario);
            session.setAttribute("usuario", usuario);
            return "redirect:buscarTodos.do";
        }
    }

    @RequestMapping(value = "/modificarDatos.do", method = RequestMethod.POST)
    public String modificarUsuario(Usuario modificacion, HttpSession session) {
        if (session == null) return "index";
        Usuario usuarioPrincipal= (Usuario) session.getAttribute("usuario");
        modificacion.setEstado(usuarioPrincipal.getEstado());
        modificacion.setSeguidos(usuarioPrincipal.getSeguidos());
        usuarioBusiness.modificar(modificacion);
        session.setAttribute("usuario", modificacion);
        return "redirect:buscarTodos.do";
    }


    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String logueo(Usuario usuario, HttpSession session) {
        if (usuarioBusiness.comprobarLogin(usuario)) {
            session.setAttribute("usuario", usuarioBusiness.recogerUsuario(usuario));
            return "redirect:buscarTodos.do";
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/logout.do", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @RequestMapping(value = "/buscarTodos.do", method = RequestMethod.GET)
    public String mostrarTodosUsuarios(Model model, HttpSession session) {
        if (session == null) return "index";
        model.addAttribute("busqueda", null);
        model.addAttribute("listaSeguidos", usuarioBusiness.recuperarTodosLosSeguidores((Usuario) session.getAttribute("usuario")));
        return "mainMenu";
    }

    @RequestMapping(value = "/dejarDeSeguir.do", method = RequestMethod.POST)
    public String dejarDeSeguir(@RequestParam("nombreUsuario") String siguiendo,HttpSession session) {
        if (session == null) return "index";
        usuarioBusiness.dejarDeSeguir((Usuario) session.getAttribute("usuario"), siguiendo);
        return "redirect:buscarTodos.do";
    }

    @RequestMapping(value = "/buscarUsuario.do", method = RequestMethod.POST)
    public String buscarPorNombre(String nombre, Model model, HttpSession session) {
        if (session == null) return "index";
        model.addAttribute("busqueda", null);
        model.addAttribute("busqueda", usuarioBusiness.buscar((Usuario) session.getAttribute("usuario"), nombre));
        return "buscadorUsuarios";
    }

    @RequestMapping(value = "/seguir.do", method = RequestMethod.POST)
    public String seguirUsuario(@RequestParam("nombreUsuario") String follow, HttpSession session) {
        if (session == null) return "index";
        Usuario usuarioNuevo = (Usuario) session.getAttribute("usuario");
        List<Usuario> lista = usuarioBusiness.seguir(usuarioNuevo, follow);
        usuarioNuevo.setSeguidos(lista);
        session.setAttribute("usuario",usuarioNuevo);
        return "redirect:buscarTodos.do";
    }

    @RequestMapping(value = "/modificarEstado.do", method = RequestMethod.POST)
    public String modificarEstado(@RequestParam("estado")String estado, HttpSession session) {
        if (session == null) return "index";
        usuarioBusiness.modificarEstado((Usuario)session.getAttribute("usuario"), estado);
        Usuario usuarioNuevo=(Usuario)session.getAttribute("usuario");
        usuarioNuevo.setEstado(estado);
        session.setAttribute("usuario",usuarioNuevo);
        return "redirect:buscarTodos.do";
    }
}
