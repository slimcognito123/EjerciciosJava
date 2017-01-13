package Modelo.Factories;

import Modelo.Personas.PersonaDAO;
import Modelo.Personas.PersonaONLINE;

public class FactoryPersonaDAO {

    public PersonaDAO comprobarEstadoArchivoConfiguracion() {
        Integer numeroOpcion =2;
        /*if (numeroOpcion == 0) return new PersonaDAOFichero();
        else if (numeroOpcion == 1) return new PersonaDAOJDBC();
        else */if (numeroOpcion == 2) return new PersonaONLINE();
        else {
            System.out.println("ya's tocao, siesque no pueh se");
            return null;
        }
    }

}
