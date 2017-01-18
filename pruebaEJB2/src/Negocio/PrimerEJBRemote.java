package Negocio;

import javax.ejb.Remote;

@Remote
public interface PrimerEJBRemote {
    String saludo(String nombre);
}
