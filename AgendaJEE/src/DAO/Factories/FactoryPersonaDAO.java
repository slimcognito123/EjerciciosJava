package DAO.Factories;

import DAO.Ficheros.FicheroLectura;
import DAO.Personas.PersonaDAO;
import DAO.Personas.PersonaDAOFichero;
import DAO.Personas.PersonaDAOJDBC;
import DAO.Personas.PersonaONLINE;
import Exceptions.MyException;

public class FactoryPersonaDAO {

    public PersonaDAO comprobarEstadoArchivoConfiguracion() throws MyException {
        //FicheroLectura lector = new FicheroLectura("agenda.cfg");
        //String linea = lector.leerLinea();
        Integer numeroOpcion =2;
        /*try {
            numeroOpcion = Integer.parseInt(linea.split(" ")[1]);
        } catch (Exception e) {
            System.err.println("archivo de configuracion mal escrito, por favor, compruebelo " + e);
        }*/

        if (numeroOpcion == 0) return new PersonaDAOFichero();
        else if (numeroOpcion == 1) return new PersonaDAOJDBC();
        else if (numeroOpcion == 2) return new PersonaONLINE();
        else {
            throw new MyException("numero introducido en archivo de configuracion no valido");
        }
    }

}
