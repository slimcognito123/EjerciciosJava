package EjerEsquema;

import java.io.*;

public class FicheroLectura {

    BufferedReader buferDelFichero;
    String nombreFichero;
    private FileReader fileReader;

    public FicheroLectura(String nombreFichero) {
        this.nombreFichero = nombreFichero;
        this.fileReader = initFileReader();
        this.buferDelFichero = new BufferedReader(fileReader);
    }

    private FileReader initFileReader() {
        try {
            return new FileReader(this.nombreFichero);
        } catch (FileNotFoundException e) {
            System.out.println("no has iniciado bien el fail rider " + e);
        }
        return null;
    }

    public String leerLinea() {
        String linea = "";
        if (buferDelFichero != null) {
            try {
                linea = this.buferDelFichero.readLine();
            } catch (IOException e) {
                System.out.println("no se pudo leer el fichero " + e);
            }
        }
        return linea;
    }

    public String leerCadena() {
        return null;
    }

    public String leerCadena(String cadena) {
        return null;
    }
}
