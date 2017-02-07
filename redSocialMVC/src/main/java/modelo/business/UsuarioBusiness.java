package modelo.business;

import beans.Usuario;
import modelo.DAO.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "usuarioBusiness")
public class UsuarioBusiness {

    @Autowired
    @Qualifier("usuarioDAO")
    private UsuarioDAO usuarioDAO;

    @Transactional
    public boolean comprobarLogin(Usuario usuario) {
        return usuarioDAO.comprobarLogin(usuario);
    }

    @Transactional
    public void insertarUsuario(Usuario user) {
        usuarioDAO.insertarUsuario(user);
    }

    @Transactional
    public boolean comprobarUsuarioExistente(String usuario) {
        return usuarioDAO.comprobarUsuarioExistente(usuario);
    }

    @Transactional
    public List<Usuario> recuperarTodosLosSeguidores(Usuario usuario) {
        return usuarioDAO.recogerSeguidores(usuario);
    }

    @Transactional
    public void dejarDeSeguir(Usuario usuario, String siguiendo) {
        usuarioDAO.dejarDeSeguir(usuario, siguiendo);
    }

    @Transactional
    public ArrayList<Usuario> buscar(Usuario usuario, String nombre) {
        return usuarioDAO.buscar(usuario,nombre);
    }

    @Transactional
    public List<Usuario> seguir(Usuario usuario, String follow) {
        return usuarioDAO.seguir(usuario,follow);
    }

    @Transactional
    public void modificar(Usuario modificacion) {
        usuarioDAO.modificar(modificacion);
    }
    @Transactional
    public Usuario recogerUsuario(Usuario usuario) {
        return usuarioDAO.getUsuario(usuario.getNombreUsuario());
    }
    @Transactional
    public void modificarEstado(Usuario usuario, String estado) {
        usuarioDAO.setEstado(usuario,estado);
    }
}

