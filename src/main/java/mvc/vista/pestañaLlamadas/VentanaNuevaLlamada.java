package mvc.vista.pestañaLlamadas;

import mvc.controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaNuevaLlamada {

    private Controlador controlador;

    public VentanaNuevaLlamada (Controlador controlador){
        this.controlador=controlador;
    }

    private void GUI() {
        JFrame ventana = new JFrame("Nueva Llamada");
        Container contenedor = ventana.getContentPane();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.LINE_AXIS));
        JLabel nif_desc = new JLabel("NIF: ");
        JTextField nif_text = new JTextField();

        panel1.add(nif_desc);
        panel1.add(nif_text);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        JLabel num_desc = new JLabel("Numero de destino: ");
        JTextField num_text = new JTextField();

        panel2.add(num_desc);
        panel2.add(num_text);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.LINE_AXIS));
        JLabel dur_desc = new JLabel("Duracion (min): ");
        JTextField dur_text = new JTextField();

        panel3.add(dur_desc);
        panel3.add(dur_text);

        JPanel panel4 = new JPanel();
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nif = nif_text.getText();
                long num = Long.parseLong(num_text.getText());
                int dur = Integer.parseInt(dur_text.getText());
                controlador.anadirLlamada(nif, num, dur);
                ventana.dispose();
            }
        });
        panel4.add(aceptar);

        contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.PAGE_AXIS));
        contenedor.add(panel1);
        contenedor.add(panel2);
        contenedor.add(panel3);
        contenedor.add(panel4);

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
