package PruebasJFrames;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class PruebaFrames {
    public PruebaFrames() {
        JFrame frame = new JFrame("Mi primer Frame jajajajajajjajajajajajjaja");
        frame.setSize(500,400);
        frame.setDefaultCloseOperation(3);
        frame.setLocation(500,130);
        //frame.setLocationRelativeTo(null);
        try {
            frame.setIconImage( (new ImageIcon(new URL("http://www.definicionabc.com/wp-content/uploads/Im%C3%A1gen-Vectorial.jpg"))).getImage());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        frame.setResizable(false);

        frame.setVisible(true);
    }
    public static void main(String[] args){
        new PruebaFrames();
    }
}
