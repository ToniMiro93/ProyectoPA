package mvc.vista.pestañaLlamadas;

import mvc.modelo.InterrogaModelo;
import mvc.vista.tabla.VentanaTabla;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class VentanaLlamadasEntreFechas {

    private InterrogaModelo modelo;

    public VentanaLlamadasEntreFechas (InterrogaModelo modelo){
        this.modelo = modelo;
    }

    private void GUI() {
        JFrame ventana = new JFrame("Listar Llamadas Entre Fechas");
        Container contenedor = ventana.getContentPane();

        JPanel panel0 = new JPanel();
        panel0.setLayout(new BoxLayout(panel0, BoxLayout.LINE_AXIS));
        JLabel nif_desc = new JLabel("NIF: ");
        JTextField nif_text = new JTextField();
        panel0.add(nif_desc);
        panel0.add(nif_text);


        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JLabel descripcion = new JLabel("Introduzca las dos fechas: ");
        panel1.add(descripcion);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        JLabel fecha1_desc = new JLabel("Primera fecha");
        JLabel dia1_desc = new JLabel("Dia: ");
        JLabel mes1_desc = new JLabel("Mes: ");
        JLabel ano1_desc = new JLabel("Ano: ");
        JTextField dia1_text = new JTextField();
        JTextField mes1_text = new JTextField();
        JTextField ano1_text = new JTextField();
        panel2.add(fecha1_desc);
        panel2.add(dia1_desc);
        panel2.add(dia1_text);
        panel2.add(mes1_desc);
        panel2.add(mes1_text);
        panel2.add(ano1_desc);
        panel2.add(ano1_text);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
        JLabel fecha2_desc = new JLabel("Segunda fecha");
        JLabel dia2_desc = new JLabel("Dia: ");
        JLabel mes2_desc = new JLabel("Mes: ");
        JLabel ano2_desc = new JLabel("Ano: ");
        JTextField dia2_text = new JTextField();
        JTextField mes2_text = new JTextField();
        JTextField ano2_text = new JTextField();
        panel3.add(fecha2_desc);
        panel3.add(dia2_desc);
        panel3.add(dia2_text);
        panel3.add(mes2_desc);
        panel3.add(mes2_text);
        panel3.add(ano2_desc);
        panel3.add(ano2_text);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nif = nif_text.getText();
                Integer dia1 = Integer.parseInt(dia1_text.getText());
                Integer mes1 = Integer.parseInt(mes1_text.getText());
                Integer ano1 = Integer.parseInt(ano1_text.getText());
                Integer dia2 = Integer.parseInt(dia2_text.getText());
                Integer mes2 = Integer.parseInt(mes2_text.getText());
                Integer ano2 = Integer.parseInt(ano2_text.getText());
                LocalDate fecha1 = LocalDate.of(ano1, mes1, dia1);
                LocalDate fecha2 = LocalDate.of(ano2, mes2, dia2);
                AbstractTableModel modeloTabla = modelo.llamadasEntreFechas(nif, fecha1, fecha2);
                SwingUtilities.invokeLater(() -> new VentanaTabla().GUI(modeloTabla));
                ventana.dispose();
            }
        });
        panel4.add(aceptar);

        contenedor.setLayout(new BoxLayout(contenedor,BoxLayout.PAGE_AXIS));
        contenedor.add(panel0);
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
