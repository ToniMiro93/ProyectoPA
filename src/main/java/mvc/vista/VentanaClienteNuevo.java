package mvc.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaClienteNuevo {
    private void GUI() {
        JFrame ventana = new JFrame("Nuevo Cliente");
        Container contenedor = ventana.getContentPane();
        JPanel panelLabel= new JPanel();
        JPanel panelField=new JPanel();
        JLabel nombre= new JLabel("Nombre:");
  //      nombre.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel apellidos= new JLabel("Apellidos:");
//        apellidos.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel nif=new JLabel("NIF:");
//        nif.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel email=new JLabel("Correo:");
        JLabel poblacion=new JLabel("Población:");
        JLabel provincia=new JLabel("Provincia:");
        JLabel codPostal=new JLabel("Código postal:");
        panelLabel.add(nombre);
        panelLabel.add(apellidos);
        panelLabel.add(nif);
        panelLabel.add(email);
        panelLabel.add(poblacion);
        panelLabel.add(provincia);
        panelLabel.add(codPostal);
        contenedor.add(panelLabel, BorderLayout.WEST);

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
