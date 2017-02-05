package modelo.factories;

import modelo.contactos.ContactoDAO;
import modelo.contactos.ContactoJPA;

public class FactoryPersonaDAO {

    public ContactoDAO comprobarEstadoArchivoConfiguracion() {
        //return new ContactoONLINE();
        return new ContactoJPA();
    }

}
