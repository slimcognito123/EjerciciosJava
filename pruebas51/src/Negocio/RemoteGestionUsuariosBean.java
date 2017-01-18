package Negocio;

import javax.ejb.Remote;

@Remote
public interface RemoteGestionUsuariosBean {
    boolean login(String nombre, String pass);
}
