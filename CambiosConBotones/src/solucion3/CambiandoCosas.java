package solucion3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambiandoCosas implements ActionListener {
    private final PruebaConSolucion3 solucion3;

    public CambiandoCosas(PruebaConSolucion3 solucion3) {
        this.solucion3=solucion3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        solucion3.boton.setFont(new Font("Consoles",3,23));
        solucion3.boton.setBackground(Color.red);
        solucion3.frame.setTitle("holiwis he cambiado :3");
    }
}
