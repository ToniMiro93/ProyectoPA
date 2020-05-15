package mvc.vista;

import mvc.controlador.Controlador;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

public class VentanaBorrar {
    private Controlador controlador;

    public VentanaBorrar (Controlador controlador){
        this.controlador=controlador;
    }
    private void GUI() {
        JFrame ventana = new JFrame("Borrar Cliente");
        Container contenedor = ventana.getContentPane();
        JPanel panelPrincipal=new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal,BoxLayout.LINE_AXIS));
        JLabel dni=new JLabel("DNI:");
        JTextField campo= new JTextField(20);
        panelPrincipal.add(dni);
        panelPrincipal.add(campo);
        contenedor.add(panelPrincipal);
        ventana.setDefaultCloseOperation(ventana.HIDE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }

    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI();
            }
        });
    }
}
