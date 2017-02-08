package Modelo.DAO.Factories;

import Modelo.DAO.Contactos.ContactoDAO;
import Modelo.DAO.Contactos.ContactoDAOMongo;

public class FactoryPersonaDAO {

    public ContactoDAO comprobarEstadoArchivoConfiguracion() {
        //return new ContactoONLINE();
        return new ContactoDAOMongo();
    }

}
