package mvc.vista.pestañaClientes;

import mvc.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRecuperarCliente {

    private Controlador controlador;

    public VentanaRecuperarCliente (Controlador controlador){
        this.controlador=controlador;
    }
    private void GUI() {
        JFrame ventana = new JFrame("Recuperar Cliente");
        Container contenedor = ventana.getContentPane();

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior,BoxLayout.LINE_AXIS)); //PAGE_AXIS
        JLabel dni=new JLabel("DNI:");
        JTextField campo= new JTextField(20);
        panelSuperior.add(dni);
        panelSuperior.add(campo);

        JPanel panelInferior = new JPanel();
        JButton boton = new JButton("Aceptar");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nif = campo.getText();



//                controlador.recuperarCliente(nif);
                ventana.dispose();
            }
        });
        panelInferior.add(boton);

        contenedor.setLayout(new GridLayout(2,1));
        contenedor.add(panelSuperior);
        contenedor.add(panelInferior);

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
