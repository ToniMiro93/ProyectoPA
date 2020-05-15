package mvc.vista.pestanaClientes;

import mvc.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCambiarTarifa {

    private Controlador controlador;

    public VentanaCambiarTarifa (Controlador controlador){
        this.controlador=controlador;
    }

    private void GUI(){
        JFrame ventana = new JFrame("Cambiar Tarifa");
        Container contenedor = ventana.getContentPane();

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.LINE_AXIS));
        JLabel nif = new JLabel("Introduzca el nif: ");
        JTextField campo = new JTextField(20);
        panelSuperior.add(nif);
        panelSuperior.add(campo);

        JPanel panelCen1 = new JPanel();
        JLabel tarifaDescripcion = new JLabel("Elija la tarifa deseada: ");
        panelCen1.add(tarifaDescripcion);

        JPanel panelCen2 = new JPanel();
        panelCen2.setLayout(new BoxLayout(panelCen2, BoxLayout.LINE_AXIS));
        JRadioButton TarifaTardes = new JRadioButton("Tarifa Tardes");
        JRadioButton TarifaDomingos = new JRadioButton("Tarifa Domingo");
        TarifaTardes.setSelected(true);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(TarifaTardes);
        grupo.add(TarifaDomingos);


        panelCen2.add(TarifaTardes);
        panelCen2.add(TarifaDomingos);


        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));
        panelCentral.add(panelCen1);
        panelCentral.add(panelCen2);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nif = campo.getText();
                String tarifa = "Tarifa Tardes";
                if (TarifaDomingos.isSelected())
                    tarifa = "Tarifa Domingos";
                controlador.cambiarTarifa(nif, tarifa);
                ventana.dispose();
            }
        });
        panelInferior.add(aceptar);

        contenedor.setLayout(new GridLayout(3,1));
        contenedor.add(panelSuperior);
        contenedor.add(panelCentral);
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
