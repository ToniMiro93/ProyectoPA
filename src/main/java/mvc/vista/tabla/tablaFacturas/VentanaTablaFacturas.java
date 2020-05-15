package mvc.vista.tabla.tablaFacturas;

import mvc.modelo.tablas.ModeloTablaFacturas;
import mvc.vista.tabla.Tabla;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaTablaFacturas {

    public void GUI(){
        JFrame ventana = new JFrame("Tabla de facturas");
        ModeloTablaFacturas modeloTabla = new ModeloTablaFacturas(new ArrayList<>()); //CAMBIAAR
        Tabla tabla = new Tabla(modeloTabla);
        Container contenedor = ventana.getContentPane();
        contenedor.add(new JScrollPane(tabla));

        JButton boton = new JButton("Actualizar la tabla");
        boton.addActionListener(e -> tabla.setModel(new ModeloTablaFacturas(new ArrayList<>()))); // CAMBIAR
        contenedor.add(boton, BorderLayout.SOUTH);

        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }


}
