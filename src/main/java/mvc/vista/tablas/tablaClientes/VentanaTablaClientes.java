package mvc.vista.tablas.tablaClientes;

import mvc.modelo.InterrogaModelo;
import mvc.modelo.tablas.ModeloTablaClientes;
import mvc.vista.tablas.Tabla;

import javax.swing.*;
import java.awt.*;

public class VentanaTablaClientes {



    public void GUI(InterrogaModelo modelo){
        JFrame ventana = new JFrame("Tabla de clientes");

        ModeloTablaClientes modeloTabla = new ModeloTablaClientes(modelo.listarClientes());


        Tabla tabla = new Tabla(modeloTabla);
        Container contenedor = ventana.getContentPane();
        contenedor.add(new JScrollPane(tabla));



        JButton boton = new JButton("Actualizar la tabla");
        boton.addActionListener(e -> tabla.setModel(new ModeloTablaClientes(modelo.listarClientes())));
        contenedor.add(boton, BorderLayout.SOUTH);

        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
