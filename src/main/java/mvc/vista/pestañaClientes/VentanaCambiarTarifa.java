package mvc.vista.pestañaClientes;

import mvc.controlador.Controlador;
import nombres.NIF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
        JTextField campo1 = new JTextField(20);
        panelSuperior.add(nif);
        panelSuperior.add(campo1);

        JPanel panelCen1 = new JPanel();
        JLabel tarifa = new JLabel("Elija la tarifa deseada: ");
        panelCen1.add(tarifa);

        JPanel panelCen2 = new JPanel();
        panelCen2.setLayout(new BoxLayout(panelCen2, BoxLayout.LINE_AXIS));
        JRadioButton TarifaTardes = new JRadioButton("Tarifa Tardes");
        JRadioButton TarifaDomingos = new JRadioButton("Tarifa Domingo");
        TarifaTardes.setSelected(true);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(TarifaTardes);
        grupo.add(TarifaDomingos);

        /*grupo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                switch(e.getStateChange()) {
                    case ItemEvent.SELECTED:
                        campo2.setEnabled(false);
                        break;
                    case ItemEvent.DESELECTED:
                        campo2.setEnabled(true);
                        break;
                }
            }
        });*/

        panelCen2.add(TarifaTardes);
        panelCen2.add(TarifaDomingos);


        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));
        panelCentral.add(panelCen1);
        panelCentral.add(panelCen2);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());
        JButton aceptar = new JButton("Aceptar");
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
