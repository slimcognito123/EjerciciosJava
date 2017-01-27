package Modelo.Factories;

import Modelo.Contactos.ContactoDAO;
import Modelo.Contactos.ContactoJPA;

public class FactoryPersonaDAO {

    public ContactoDAO comprobarEstadoArchivoConfiguracion() {
        //return new ContactoONLINE();
        return new ContactoJPA();
    }

}
