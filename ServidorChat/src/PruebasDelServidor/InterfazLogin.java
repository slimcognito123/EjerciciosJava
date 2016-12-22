package PruebasDelServidor;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class InterfazLogin extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new InterfazLogin();
	}
	//CONTROLES GRAFICOS DEL CHAT
	JPanel jpanel = (JPanel) this.getContentPane();
	private static Socket cliente; //Socket para conectarse con el cliente
    private static String ip = "127.0.0.1"; //ip a la cual se conecta
    private static int puerto; //puerto a la cual se conecta static PrincipalChat main; 
	  
	  // CONSTRUCTOR
	  public InterfazLogin() {
			
	      //PROPIEDADES DEL CONTENEDOR
		  	jpanel.setLayout (new GridLayout (4,2));  // 3 filas y 1 columnas
		  	JTextField jnombre = new JTextField();
	        JTextField jip = new JTextField();
	        JTextField jpuerto = new JTextField();
	        JButton jboton = new JButton();
	        JLabel labelnombre = new JLabel();
	        JLabel labelip = new JLabel();
	        JLabel labelpuerto = new JLabel();
	        //A�ADIR AL MENU
	        jpanel.add(labelnombre,null);
		    jpanel.add(jnombre, null);
		    jpanel.add(labelip,null);
		    jpanel.add(jip, null);
		    jpanel.add(labelpuerto,null);
		    jpanel.add(jpuerto, null);
		    jpanel.add(jboton,null);

	      //PROPIEDADES DE LOS CONTROLES 
		    labelnombre.setText("Nombre:");
		    labelnombre.setForeground (Color.red);
		    labelip.setText("IP:");
		    labelip.setForeground (Color.red);
		    labelpuerto.setText("Puerto:");
		    labelpuerto.setForeground (Color.red);
		    jboton.setText("Acceder");
	      //Crea menu Archivo y submenu Salir, ademas agrega el submenu al menu
	        JMenu menuArchivo = new JMenu("Archivo"); 
	        JMenuItem salir = new JMenuItem("Salir");
	        //JMenu menuConectarse = new JMenu("Conectarse");
	        menuArchivo.add(salir); //Agrega el submenu Salir al menu menuArchivo
	        JMenuBar barra = new JMenuBar(); //Crea la barra de menus
	        setJMenuBar(barra); //Agrega barra de menus a la aplicacion
	        barra.add(menuArchivo); //agrega menuArchivo a la barra de menus
	        //barra.add(menuConectarse);
	        //Accion que se realiza cuando se presiona el submenu Salir
	        salir.addActionListener(new ActionListener() { //clase interna anonima
	                public void actionPerformed(ActionEvent e) {
	                    System.exit(0); //Sale de la aplicacion
	                }
	        });
	        //Accion que se realiza cuando se presiona el boton conectar
	        jboton.addActionListener(new ActionListener() { //clase interna anonima
	                public void actionPerformed(ActionEvent e) {
	                	int puerto=new Integer(jpuerto.getText());
	                    ControlUsuario con = new ControlUsuario(jnombre.getText(),puerto,jip.getText()); //Sale de la aplicacion
	                    con.conectarse();
	                    setVisible(false);
	                    System.out.println("se intenta realizar al conexion");
	                }
	        });
	        
	      //PROPIEDADES DEL LOGIN         
		     setSize(400,500);
		     setTitle("Chat");
		     setLocationRelativeTo(null);
		     setBackground(Color.CYAN); //Pone de color cyan al displayArea
		     setForeground(Color.BLACK); //pinta azul la letra en el displayArea
		     setForeground(Color.BLACK); //pinta toja la letra del mensaje a enviar
		     
		     setVisible(true); //Pone visible la ventana

	     //LOOK AND FEEL
	     setDefaultLookAndFeelDecorated(true);
	     Image image = (new ImageIcon("C:/Users/Public/Pictures/Sample Pictures/Koala.jpg")).getImage();
	     setIconImage(image);
	     try{
	    	 
	    	 UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	    	 
	     }	catch (Exception e){
	  	  e.printStackTrace();
	  	 }
	  }
	  
	//METODOS PARA EL CHAT
	  
}
