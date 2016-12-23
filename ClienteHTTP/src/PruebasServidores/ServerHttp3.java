package PruebasServidores;

import com.sun.org.apache.bcel.internal.classfile.ConstantString;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.sql.Blob;

public class ServerHttp3 {

    public static final String PON_ESTO_PA_QUE_TIRE = "HTTP/1.1 200 OK\r\n\r\n";

    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            try (Socket socket = server.accept()) {
                InputStreamReader lector = new InputStreamReader(socket.getInputStream());
                BufferedReader lectorBueno= new BufferedReader(lector);
                String cabecera = lectorBueno.readLine();
                String httpResponse;
                if(cabecera.split(" ")[1].equals("/index.html")){
                    httpResponse=PON_ESTO_PA_QUE_TIRE +"<html>; <body>; <h1>Hola que tal!</h1> </body> </html>;";
                    socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                }else if(cabecera.split(" ")[1].equals("imagen.jpg")){
                    httpResponse=PON_ESTO_PA_QUE_TIRE +"Content-Type: jpg\r\n\r\n";
                    File imagen  = new File("imagen.jpeg");
                    byte[] arrayBytes= Files.readAllBytes(imagen.toPath());
                    socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                    socket.getOutputStream().write(arrayBytes);
                }else{
                    httpResponse = PON_ESTO_PA_QUE_TIRE + cabecera;
                }
            }
        }
    }
}
