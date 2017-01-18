package dao;

import beans.Usuario;

import javax.ejb.Local;

@Local
public interface UsarioDAOBeanLocal {
    public Usuario recuperarUsuario(String name);
}
