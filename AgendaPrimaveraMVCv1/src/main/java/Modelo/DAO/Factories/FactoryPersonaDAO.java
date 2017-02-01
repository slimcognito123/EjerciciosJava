package Modelo.DAO.Factories;

import Modelo.DAO.Contactos.ContactoDAO;
import Modelo.DAO.Contactos.ContactoJPA;

public class FactoryPersonaDAO {

    public ContactoDAO comprobarEstadoArchivoConfiguracion() {
        //return new ContactoONLINE();
        return new ContactoJPA();
    }

}
