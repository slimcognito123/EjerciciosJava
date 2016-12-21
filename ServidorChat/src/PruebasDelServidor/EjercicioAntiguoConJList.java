package PruebasDelServidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class EjercicioAntiguoConJList implements ActionListener{
	public static void main(String args[]){
		new EjercicioAntiguoConJList();
	}
	JFrame frame=new JFrame("Examen");
	JPanel panel=new JPanel();
	JButton boton=new JButton("Calcular");
	JCheckBox objeto1 =new JCheckBox("objeto1");
	JCheckBox objeto2 =new JCheckBox("objeto2");
	JCheckBox objeto3 =new JCheckBox("objeto3");
	String []patata={"tipo 1", "tipo 2", "tipo 3"};
	JList lista =new JList();
	DefaultListModel modelo =new DefaultListModel();
	JTextField total =new JTextField();
	
	public EjercicioAntiguoConJList(){
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setSize(500,500);
		panel.setLayout(null);
		panel.add(boton);
		panel.add(objeto1);
		panel.add(objeto2);
		panel.add(objeto3);
		panel.add(lista);
		lista.setModel(modelo);
		panel.add(total);
		lista.setBounds(20,100,150,300);
		boton.setBounds(300,300,100,40);
		objeto1.setBounds(300,50,100,40);
		objeto2.setBounds(300,100,100,40);
		objeto3.setBounds(300,150,100,40);
		total.setBounds(230,370,100,40);
		modelo.addElement("tipo 1");
		modelo.addElement("tipo 2");
		modelo.addElement("tipo 3");
		boton.addActionListener(this);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int patata=0;
		if (lista.getSelectedIndex()==0)patata=100;
		if (lista.getSelectedIndex()==1)patata=200;
		if (lista.getSelectedIndex()==2)patata=300;
		if(objeto1.isSelected()==true) patata=patata+50;
		if(objeto2.isSelected()==true) patata=patata+50;
		if(objeto3.isSelected()==true) patata=patata+50;
		total.setText(""+patata);
	}
}
