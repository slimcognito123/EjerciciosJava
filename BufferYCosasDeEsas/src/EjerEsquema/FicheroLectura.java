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
        String palabra = "";
        if (buferDelFichero != null) {
            try {
                String frase = this.buferDelFichero.readLine();
                palabra=frase.split(" ")[0];
            } catch (IOException e) {
                System.out.println("no se pudo leer el fichero " + e);
            }
        }
        return palabra;
    }

    public String leerCadena(String cadena) {

        String palabra = "";
        if (buferDelFichero != null) {
            try {
                String frase = this.buferDelFichero.readLine();
                int i=0;
                while(cadena!=palabra && palabra!="\n")palabra=frase.split(" ")[i];
                if(cadena==palabra)return palabra;
            } catch (IOException e) {
                System.out.println("no se pudo leer el fichero " + e);
            }
        }
        System.out.println("no se encontró la palabra");
        return null;
    }
}
