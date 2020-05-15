package mvc.vista.tablas.tablaLlamadas;

import mvc.modelo.tablas.ModeloTablaLlamadas;
import mvc.vista.tablas.Tabla;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaTablaLlamadas {

    public void GUI(){
        JFrame ventana = new JFrame("Tabla de llamadas");
        ModeloTablaLlamadas modeloTabla = new ModeloTablaLlamadas(new ArrayList<>()); //CAMBIAAR
        Tabla tabla = new Tabla(modeloTabla);
        Container contenedor = ventana.getContentPane();
        contenedor.add(new JScrollPane(tabla));

        JButton boton = new JButton("Actualizar la tabla");
        boton.addActionListener(e -> tabla.setModel(new ModeloTablaLlamadas(new ArrayList<>()))); // CAMBIAR
        contenedor.add(boton, BorderLayout.SOUTH);

        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
