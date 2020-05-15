package mvc.vista.tablas.tablaClientes;

import data.cliente.Cliente;
import mvc.modelo.InterrogaModelo;
import mvc.vista.tablas.Tabla;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaTablaClientes {



    public void GUI(InterrogaModelo modelo){
        JFrame ventana = new JFrame("Tabla de clientes");
        ArrayList<Cliente> clientes;

        ModeloTablaClientes modeloTabla = new ModeloTablaClientes(modelo.listarClientes());//CAMBIAAR
        Tabla tabla = new Tabla(modeloTabla);
        Container contenedor = ventana.getContentPane();
        contenedor.add(new JScrollPane(tabla));



        JButton boton = new JButton("Actualizar la tabla");
        boton.addActionListener(e -> tabla.setModel(new ModeloTablaClientes(modelo.listarClientes()))); // CAMBIAR
        contenedor.add(boton, BorderLayout.SOUTH);

        ventana.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
    }
}
