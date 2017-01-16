package Modelo.Factories;

import Modelo.Personas.PersonaDAO;
import Modelo.Personas.PersonaONLINE;

public class FactoryPersonaDAO {

    public PersonaDAO comprobarEstadoArchivoConfiguracion() {
        return new PersonaONLINE();

    }

}
