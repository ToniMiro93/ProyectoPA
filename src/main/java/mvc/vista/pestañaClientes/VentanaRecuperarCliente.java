package mvc.vista.pestañaClientes;

import mvc.controlador.Controlador;
import mvc.modelo.InterrogaModelo;
import mvc.modelo.Modelo;
import mvc.vista.tabla.VentanaTabla;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRecuperarCliente {

    private InterrogaModelo modelo;

    public VentanaRecuperarCliente (InterrogaModelo modelo){
        this.modelo = modelo;
    }
    private void GUI() {
        JFrame ventana = new JFrame("Recuperar Cliente");
        Container contenedor = ventana.getContentPane();

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior,BoxLayout.LINE_AXIS));
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
                AbstractTableModel modeloTabla = modelo.recuperarCliente(nif);
                SwingUtilities.invokeLater(() -> new VentanaTabla().GUI(modeloTabla));

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
