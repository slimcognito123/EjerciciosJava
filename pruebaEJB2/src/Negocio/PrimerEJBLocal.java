package Negocio;

import javax.ejb.Local;

@Local
public interface PrimerEJBLocal {
    String saludo(String nombre);
}
