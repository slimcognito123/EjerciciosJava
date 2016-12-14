package DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
            System.err.println("no has iniciado bien el fail rider " + e);
        }
        return null;
    }

    public String leerLinea() {
        String linea = "";
        if (buferDelFichero != null) {
            try {
                linea = this.buferDelFichero.readLine();
            } catch (IOException e) {
                System.err.println("no se pudo leer el fichero " + e);
            }
        }
        return linea;
    }

    public String leerCadena() {
        String palabra = "";
        char letra;
        if (buferDelFichero != null) {
            /*try {
                String frase = this.buferDelFichero.readLine();
                palabra=frase.split(" ")[0];
            } catch (IOException e) {
                System.out.println("no se pudo leer el fichero " + e);
            }*/
            try {
                while ((letra = ((char) this.buferDelFichero.read())) != (char) 32 && (int)letra !=65535) {
                    palabra += letra;
                    System.out.println((int)letra);
                }
                System.out.println((int)letra);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return palabra;
    }

    public String leerCadena(char separador) {
        String palabra = "";
        char letra;
        if (buferDelFichero != null) {
            try {
                while ((letra = ((char) this.buferDelFichero.read())) != separador && (int)letra != 65535) {
                    palabra += letra;
                }
            } catch (IOException e) {
                System.err.println("fallo en el archivo");
            }
        }
        return palabra;
    }
    public void volverAlPrincipio(){
        try {
            buferDelFichero.reset();
        } catch (IOException e) {
            System.out.println("no se ha podido volver al principio del fichero");
        }
    }
}
