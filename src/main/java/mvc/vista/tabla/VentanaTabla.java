package mvc.vista.tabla;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class VentanaTabla {

    Tabla tabla;


    public void GUI(AbstractTableModel modelo){
        JFrame ventana = new JFrame("Tabla de clientes");

        tabla = new Tabla(modelo);
        Container contenedor = ventana.getContentPane();
        contenedor.add(new JScrollPane(tabla));

        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }

    public void actualizarTabla(AbstractTableModel modelo){
        tabla.setModel(modelo);
    }
}
