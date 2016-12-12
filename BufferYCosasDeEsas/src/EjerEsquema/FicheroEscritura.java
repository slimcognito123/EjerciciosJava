package EjerEsquema;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FicheroEscritura {

    DataInputStream file;

    public FicheroEscritura(String archivo) throws FileNotFoundException {
        FileInputStream fichero= new FileInputStream(archivo);
        DataInputStream file= new DataInputStream(fichero);
        this.file=file;
    }
    public void escribirLinea() throws IOException {


    }
}
