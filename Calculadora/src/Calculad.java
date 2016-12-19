import java.applet.AudioClip;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.Toolkit;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;


public class Calculad {
	JFrame frame =null;
	JPanel jpanel1=null;
	JPanel jpanelarriba=null;
	JPanel jpanelbotones=null;
	JTextField textoCal=null;
	JButton jbutton1 =null;
	JButton jbutton2 =null;
	JButton jbutton3 =null;
	JButton jbutton4 =null;
	JButton jbutton5 =null;
	JButton jbutton6 =null;
	JButton jbutton7 =null;
	JButton jbutton8 =null;
	JButton jbutton9 =null;
	JButton jbutton0 =null;
	JButton jbuttonC =null;
	JButton jbuttonSum = null;
	JButton jbuttonsqrt =null;
	JButton jbuttonresta =null;
	JButton jbuttonmulti =null;
	JButton jbuttondiv =null;
	JButton jbuttonporciento =null;
	JButton jbuttonCE =null;
	JButton jbuttonDelete =null;
	JButton jbuttonequal =null;
	JButton jbuttonmasmenos=null;
	JButton jbuttoncomma=null;
	JButton musiquita =null;
	Font fuente=null;
	Font fuentes=null;
	//ImageIcon boton1;
	double a,b;
	char ant;
	boolean sw,music;
	AudioClip sonido;
	AudioClip sonido2;
	public Calculad(){
		a=0;
		b=0;
		ant=' ';
		sw=false;
		music=true;
		programacion();
		frame.setVisible(true);
	}
	public void programacion(){
		frame=new JFrame();
		if(music==true){
			sonido = java.applet.Applet.newAudioClip(getClass().getResource("/imagenes/musicadefondo.wav"));
			sonido.play();
		}else{
			sonido.stop();
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Image image = toolkit.getImage("src/imagenes/Arrow.png"); 
		Point hotSpot = new Point(0,0);  
		Cursor cursor = toolkit.createCustomCursor(image, hotSpot, "Cursor");  
		fuente=new Font("Louisianne", Font.BOLD, 36);
		fuentes=new Font("Louisianne", Font.BOLD, 20);
		frame.setCursor(cursor);
		frame.setIconImage (new ImageIcon(getClass().getResource("/imagenes/calcu.jpg")).getImage());
		/*Image im = Toolkit.getDefaultToolkit().createImage("/imagenes/Arrow.png"); //La ruta entera de la imagen
		Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(0,0), "Cursor");
		*/
		
		/*Toolkit toolkit = Toolkit.getDefaultToolkit();
		  Image image = toolkit.getImage("/imagenes/Arrow.png");
		  Cursor c = toolkit.createCustomCursor(image , new Point(jpanel1.getX(),
		     jpanel1.getY()), "img");
		  frame.setCursor (c);
		*/
		//boton1=new ImageIcon("imagenes\raton.png");
		frame.setSize(290,380);
		frame.setTitle("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);

		jpanel1=new JPanel();
		//.setCursor(new Cursor("/imagenes/1.png"));
		jpanel1.setSize(300,400);
		jpanel1.setBackground(java.awt.Color.black);
		jpanel1.setLayout(null);
		frame.add(jpanel1);
		
		jpanelarriba=new JPanel();
		jpanelarriba.setBounds(2,2,280,40);
		jpanelarriba.setBackground(java.awt.Color.GRAY);
		jpanelarriba.setLayout(null);
		jpanel1.add(jpanelarriba);
		textoCal=new JTextField();
		textoCal.setBounds(2,2,275,34);
		textoCal.setForeground(java.awt.Color.decode("#FFC125"));
		textoCal.setBackground(java.awt.Color.decode("#F0FFFF"));
		textoCal.setText("0");
		textoCal.setEditable(false);
		textoCal.setHorizontalAlignment(JTextField.RIGHT);
		textoCal.setFont(fuentes);
		jpanelarriba.add(textoCal);
		jpanelbotones= new JPanel();
		jbutton1= new JButton();
		jbutton2= new JButton();
		jbutton3= new JButton();
		jbutton4= new JButton();
		jbutton5= new JButton();
		jbutton6= new JButton();
		jbutton7=new JButton();
		jbutton8= new JButton();
		jbutton9= new JButton();
		jbutton0= new JButton();
		jbuttonC= new JButton();
		jbuttonSum= new JButton();
		jbuttonsqrt= new JButton();
		jbuttonresta= new JButton();
		jbuttonmulti= new JButton();
		jbuttondiv= new JButton();
		jbuttonporciento= new JButton();
		jbuttonCE= new JButton();
		jbuttonDelete= new JButton();
		jbuttonequal= new JButton();
		jbuttonmasmenos=new JButton();
		jbuttoncomma=new JButton();
		musiquita=new JButton();
		jpanelbotones.setLayout(new GridLayout(6,5,2,2));
		jpanelbotones.setBounds(0,100,285,250);
		jpanelbotones.setBackground(java.awt.Color.BLACK);
		jpanel1.add(jpanelbotones);
		jpanelbotones.add(jbuttonDelete);
		jpanelbotones.add(jbuttonC);
		jpanelbotones.add(jbuttonCE);
		jpanelbotones.add(jbuttonsqrt);
		jpanelbotones.add(jbutton7);
		jpanelbotones.add(jbutton8);
		jpanelbotones.add(jbutton9);
		jpanelbotones.add(jbuttonmulti);
		jpanelbotones.add(jbutton4);
		jpanelbotones.add(jbutton5);
		jpanelbotones.add(jbutton6);
		jpanelbotones.add(jbuttondiv);
		jpanelbotones.add(jbutton1);
		jpanelbotones.add(jbutton2);
		jpanelbotones.add(jbutton3);
		jpanelbotones.add(jbuttonSum);
		jpanelbotones.add(jbuttonmasmenos);
		jpanelbotones.add(jbutton0);
		jpanelbotones.add(jbuttoncomma);
		jpanelbotones.add(jbuttonresta);
		jpanelbotones.add(jbuttonporciento);
		jpanelbotones.add(jbuttonequal);
		jpanelbotones.add(musiquita);
		//jbutton1.setText("1");
		jbutton1.setBackground(java.awt.Color.GRAY);
		jbutton1.setForeground(java.awt.Color.decode("#FFC125"));
		jbutton1.setBounds(0,0,80,80);
		jbutton1.setIcon(new ImageIcon(getClass().getResource("/imagenes/1.png")));
		jbutton1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('1');
				song();
			}
			
		});
		
		//jbutton2.setText("2");
		jbutton2.setBackground(java.awt.Color.GRAY);
		jbutton2.setForeground(java.awt.Color.decode("#FFC125"));
		jbutton2.setBounds(0,0,80,80);
		jbutton2.setIcon(new ImageIcon(getClass().getResource("/imagenes/2.png")));
		jbutton2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('2');
				song();
			}
			
		});
		
		//jbutton3.setText("3");
		jbutton3.setBackground(java.awt.Color.GRAY);
		jbutton3.setForeground(java.awt.Color.decode("#FFC125"));
		jbutton3.setBounds(0,0,80,80);
		jbutton3.setIcon(new ImageIcon(getClass().getResource("/imagenes/3.png")));
		jbutton3.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('3');
				song();
			}
			
		});
		
		//jbutton4.setText("4");
		jbutton4.setBackground(java.awt.Color.GRAY);
		jbutton4.setForeground(java.awt.Color.decode("#FFC125"));
		jbutton4.setBounds(0,0,80,80);
		jbutton4.setIcon(new ImageIcon(getClass().getResource("/imagenes/4.png")));
		jbutton4.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('4');
				song();
			}
			
		});
		
		//jbutton5.setText("5");
		jbutton5.setBackground(java.awt.Color.GRAY);
		jbutton5.setForeground(java.awt.Color.decode("#FFC125"));
		jbutton5.setBounds(0,0,80,80);
		jbutton5.setIcon(new ImageIcon(getClass().getResource("/imagenes/5.png")));
		jbutton5.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('5');
				song();
			}
			
		});
		
		//jbutton6.setText("6");
		jbutton6.setBackground(java.awt.Color.GRAY);
		jbutton6.setForeground(java.awt.Color.decode("#FFC125"));
		jbutton6.setBounds(0,0,80,80);
		jbutton6.setIcon(new ImageIcon(getClass().getResource("/imagenes/6.png")));
		jbutton6.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('6');
				song();
			}
			
		});
		
		//jbutton7.setText("7");
		jbutton7.setBackground(java.awt.Color.GRAY);
		jbutton7.setForeground(java.awt.Color.decode("#FFC125"));
		jbutton7.setBounds(0,0,80,80);
		jbutton7.setIcon(new ImageIcon(getClass().getResource("/imagenes/7.png")));
		jbutton7.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('7');
				song();
			}
			
		});
		
		//jbutton8.setText("8");
		jbutton8.setBackground(java.awt.Color.GRAY);
		jbutton8.setForeground(java.awt.Color.decode("#FFC125"));
		jbutton8.setBounds(0,0,80,80);
		jbutton8.setIcon(new ImageIcon(getClass().getResource("/imagenes/8.png")));
		jbutton8.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('8');
				song();
			}
			
		});
		
		//jbutton9.setText("9");
		jbutton9.setBackground(java.awt.Color.GRAY);
		jbutton9.setForeground(java.awt.Color.decode("#FFC125"));
		jbutton9.setBounds(0,0,80,80);
		jbutton9.setIcon(new ImageIcon(getClass().getResource("/imagenes/9.png")));
		jbutton9.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('9');
				song();
			}
			
		});
		
		//jbutton0.setText("0");
		jbutton0.setBackground(java.awt.Color.GRAY);
		jbutton0.setForeground(java.awt.Color.decode("#FFC125"));
		jbutton0.setBounds(0,0,80,80);
		jbutton0.setIcon(new ImageIcon(getClass().getResource("/imagenes/0.png")));
		jbutton0.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('0');
				song();
			}
			
		});
		musiquita.setBackground(java.awt.Color.BLACK);
		musiquita.setIcon(new ImageIcon(getClass().getResource("/imagenes/musica.png")));
		musiquita.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(music==true){
					music=false;
					sonido.stop();
					musiquita.setIcon(new ImageIcon(getClass().getResource("/imagenes/musicano.jpg")));
				}else{
					music=true;
					sonido.play();
					musiquita.setIcon(new ImageIcon(getClass().getResource("imagenes/musica.png")));
				}
			}
		});
		jbuttonC.setText("C");
		jbuttonC.setBackground(java.awt.Color.GRAY);
		jbuttonC.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttonC.setBounds(0,0,80,80);
		jbuttonC.setFont(fuente);
		jbuttonC.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('C');
				song();
			}
			
		});

		jbuttonSum.setText("+");
		jbuttonSum.setBackground(java.awt.Color.GRAY);
		jbuttonSum.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttonSum.setBounds(0,0,80,80);
		jbuttonSum.setFont(fuente);
		jbuttonSum.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('+');
				song();
			}
			
		});

		jbuttonsqrt.setText("^�");
		jbuttonsqrt.setBackground(java.awt.Color.GRAY);
		jbuttonsqrt.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttonsqrt.setBounds(0,0,80,80);
		jbuttonsqrt.setFont(fuentes);
		jbuttonsqrt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				calcular('s');
				song();
			}
		});

		jbuttonresta.setText("-");
		jbuttonresta.setBackground(java.awt.Color.GRAY);
		jbuttonresta.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttonresta.setBounds(0,0,80,80);
		jbuttonresta.setFont(fuente);
		jbuttonresta.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('-');
				song();
			}
			
		});
		
		jbuttonmulti.setText("*");
		jbuttonmulti.setBackground(java.awt.Color.GRAY);
		jbuttonmulti.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttonmulti.setBounds(0,0,80,80);
		jbuttonmulti.setFont(fuente);
		jbuttonmulti.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				calcular('*');
				song();
			}
		});
		
		jbuttondiv.setText("/");
		jbuttondiv.setBackground(java.awt.Color.GRAY);
		jbuttondiv.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttondiv.setBounds(0,0,80,80);
		jbuttondiv.setFont(fuente);
		jbuttondiv.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				calcular('/');
				song();
			}
			
		});
		
		jbuttonporciento.setText("%");
		jbuttonporciento.setBackground(java.awt.Color.GRAY);
		jbuttonporciento.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttonporciento.setBounds(0,0,80,80);
		jbuttonporciento.setFont(fuente);
		jbuttonporciento.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('%');
				song();
			}
			
		});
		
		jbuttonCE.setText("CE");
		jbuttonCE.setBackground(java.awt.Color.GRAY);
		jbuttonCE.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttonCE.setBounds(0,0,80,80);
		jbuttonCE.setFont(fuentes);
		jbuttonCE.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('E');
				song();
			}
			
		});
		
		//jbuttonDelete.setText("<-");
		jbuttonDelete.setBackground(java.awt.Color.GRAY);
		jbuttonDelete.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttonDelete.setBounds(0,0,80,80);
		//jbuttonDelete.setFont(fuente);
		jbuttonDelete.setIcon(new ImageIcon(getClass().getResource("imagenes/gold-arrow.png")));
		jbuttonDelete.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent arg0){
				calcular('<');
				song();
			}
		
			}
		);
		
		jbuttonequal.setText("=");
		jbuttonequal.setBackground(java.awt.Color.GRAY);
		jbuttonequal.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttonequal.setBounds(0,0,80,80);
		jbuttonequal.setFont(fuente);
		jbuttonequal.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('=');
				song();
			}
			
		});
		
		jbuttonmasmenos.setText("�");
		jbuttonmasmenos.setBackground(java.awt.Color.GRAY);
		jbuttonmasmenos.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttonmasmenos.setBounds(0,0,80,80);
		jbuttonmasmenos.setFont(fuente);
		jbuttonmasmenos.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('�');
				song();
			}
			
		});
		
		jbuttoncomma.setText(".");
		jbuttoncomma.setBackground(java.awt.Color.GRAY);
		jbuttoncomma.setForeground(java.awt.Color.decode("#FFC125"));
		jbuttoncomma.setBounds(0,0,80,80);
		jbuttoncomma.setFont(fuente);
		jbuttoncomma.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				calcular('.');
				song();
			}
			
		});
		
		jpanel1.setVisible(true);
		jpanelarriba.setVisible(true);
		textoCal.setVisible(true);
		jpanelbotones.setVisible(true);
		jbutton1.setVisible(true);
		jbutton2.setVisible(true);
		jbutton3.setVisible(true);
		jbutton4.setVisible(true);
		jbutton5.setVisible(true);
		jbutton6.setVisible(true);
		jbutton7.setVisible(true);
		jbutton8.setVisible(true);
		jbutton9.setVisible(true);
		jbutton0.setVisible(true);
		jbuttonC.setVisible(true);
		jbuttonSum.setVisible(true);
		jbuttonsqrt.setVisible(true);
		jbuttonresta.setVisible(true);
		jbuttonmulti.setVisible(true);
		jbuttondiv.setVisible(true);
		jbuttonporciento.setVisible(true);
		jbuttonCE.setVisible(true);
		jbuttonDelete.setVisible(true);
		jbuttonequal.setVisible(true);
		jbuttonmasmenos.setVisible(true);
		jbuttoncomma.setVisible(true);
		}
		public void calcular(char dato){
			switch (dato){
				case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': case '0': 
					if (textoCal.getText().compareTo("0")==0){
						textoCal.setText(String.valueOf(dato) );
					}else{
						textoCal.setText(textoCal.getText()+dato);
					}
					break;
				case '+':
					sw=false;
					a=Double.parseDouble(textoCal.getText());
					ant='+';
					textoCal.setText("0");
					break;
				case '-':
					sw=false;
					a=Double.parseDouble(textoCal.getText());
					textoCal.setText("0");
					ant='-';
					break;
				case '=':
					b=Double.parseDouble(textoCal.getText());
					switch (ant){
						case '+':
							b=b+a;
							break;
						case '-':
							b=a-b;
							break;
						case '*':
							b=b*a;
							break;
						case '%':
							b=a*b/100;
							break;
						case '/':
							b=a/b;
					}
					textoCal.setText((String.valueOf(b)));
					System.out.print(b);
					break;
				case 'C':
					sw=false;
					textoCal.setText("0");
					break;
				case 'E':
					sw=false;
					textoCal.setText("0");
					a=0;
					b=0;
					break;
				case '*':
					sw=false;
					a=Double.parseDouble(textoCal.getText());
					textoCal.setText("0");
					ant='*';
					break;
				case 's':
					sw=false;
					a=Double.parseDouble(textoCal.getText());
					b=java.lang.Math.sqrt(a);
					textoCal.setText(String.valueOf(b));
					break;
				case '%':
					sw=false;
					a=Double.parseDouble(textoCal.getText());
					ant='%';
					textoCal.setText("0");
					break;
				case '<':
					String numeros;
					int i;
					numeros=textoCal.getText();
					i=numeros.length();
					if(i==0){
						textoCal.setText("0");
					}else{
						numeros=numeros.substring(0,i-1);
						textoCal.setText(numeros);
					}
					break;
				case '.':
					String algo;
					algo=textoCal.getText();
					if(sw==false){
						algo=textoCal.getText()+".";
						sw=true;
					}
					textoCal.setText(algo);
					break;
				case '�':
					String numerosa=textoCal.getText();
					char m=numerosa.charAt(0);
					int j;
					j=numerosa.length();
					if(m=='-'){
						numerosa=numerosa.substring(1,j);
					}else{
						numerosa='-'+numerosa;
					}
					textoCal.setText(numerosa);
					break;
				case '/':
					a=Double.parseDouble(textoCal.getText());
					sw=false;
					textoCal.setText("0");
					ant='/';
				break;
			}
		}
		public void song(){
			sonido2 = java.applet.Applet.newAudioClip(getClass().getResource("/imagenes/click.wav"));
			sonido2.play();
		}
		public static void main(String[] args){
			new Calculad();
		}
	}

