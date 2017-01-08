package servidor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class PrincipalChat extends JFrame{
    public JTextArea areaTexto; //Para ingresar mensaje a enviar
    private static ServerSocket servidor; //
    private static Socket conexion; //Socket para conectarse con el cliente
    private static String ip = "127.0.0.1"; //ip a la cual se conecta
    public static final Paralizador paralizador= new Paralizador();
    public static PrincipalChat main; 
    
    public PrincipalChat(){
        super("Servidor"); //Establece titulo al Frame
        


        areaTexto = new JTextArea(); //Crear displayArea
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        areaTexto.setBackground(Color.orange); //Pone de color cyan al areaTexto
        areaTexto.setForeground(Color.BLACK); //pinta azul la letra en el areaTexto

        
        
        //Crea menu Archivo y submenu Salir, ademas agrega el submenu al menu
        JMenu menuArchivo = new JMenu("Archivo"); 
        JMenuItem salir = new JMenuItem("Salir");
        menuArchivo.add(salir); //Agrega el submenu Salir al menu menuArchivo
        
        JMenuBar barra = new JMenuBar(); //Crea la barra de menus
        setJMenuBar(barra); //Agrega barra de menus a la aplicacion
        barra.add(menuArchivo); //agrega menuArchivo a la barra de menus
        
        //Accion que se realiza cuando se presiona el submenu Salir
        salir.addActionListener(new ActionListener() { //clase interna anonima
                public void actionPerformed(ActionEvent e) {
                    System.exit(0); //Sale de la aplicacion
                }
        });
        
        setSize(300, 320); //Establecer tamano a ventana
        setVisible(true); //Pone visible la ventana
    }
    
    //Para mostrar texto en displayArea
    public void mostrarMensaje(String mensaje) {
        areaTexto.append(mensaje + "\n");
    } 

 
    
    public static void main(String[] args) {
        PrincipalChat main = new PrincipalChat(); //Instanciacion de la clase Principalchat
        main.setLocationRelativeTo(null);   //Centrar el JFrame
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //habilita cerrar la ventana
        ExecutorService executor = Executors.newCachedThreadPool(); //Para correr los threads
 
        try {
            //main.mostrarMensaje("No se encuentra Servidor");
            servidor = new ServerSocket(6555, 100); 
            main.mostrarMensaje("Esperando Cliente ...");
            ThreadEnvia enviador= new ThreadEnvia(main);
            //Bucle infinito para esperar conexiones de los clientes
            while (true){
                try {
                    conexion = servidor.accept(); //Permite al servidor aceptar conexiones        

                    //main.mostrarMensaje("Conexion Establecida");
                    main.mostrarMensaje("Conectado a : " + conexion.getInetAddress().getHostName());



                    //Ejecucion de los threads
                    ThreadRecibe threadRe = new ThreadRecibe(conexion, main);
                    executor.execute(threadRe); //client
                    String mensaje=threadRe.getMensaje();
                    enviador.addCliente(conexion);
                    Thread hiloEnviador = new Thread(enviador);
                    enviador.setMensaje(mensaje);
                    hiloEnviador.start();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } //Fin del catch
        finally {
        }
        executor.shutdown();
    }
}
