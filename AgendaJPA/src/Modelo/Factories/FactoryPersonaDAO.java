package Modelo.Factories;

import Modelo.Personas.PersonaDAO;
import Modelo.Personas.PersonaJPA;

public class FactoryPersonaDAO {

    public PersonaDAO comprobarEstadoArchivoConfiguracion() {
        //return new PersonaONLINE();
        return new PersonaJPA();
    }

}
