package mvc.vista;
import mvc.controlador.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaInicial implements InformarVista,InterrogaVista{
    private Controlador controlador;
    private JTextField jtfNombre;
    private JLabel jlContador;

    public VentanaInicial() {}
    private void GUI() {
        JFrame ventana = new JFrame("Aplicación Telefonía");
        Container contenedor = ventana.getContentPane();
        JTabbedPane pestanyas = new JTabbedPane();
        JPanel clientesPestanya=new JPanel();
        JPanel facturasPestanya=new JPanel();
        JPanel llamadasPestanya=new JPanel();
        pestanyas.add("Clientes", clientesPestanya);
        pestanyas.add("Facturas", facturasPestanya);
        pestanyas.add("Llamadas", llamadasPestanya);
        EscuchadorClientes escuchadorClientes=new EscuchadorClientes();
        JButton jbAnyadirCliente = new JButton("Añadir Cliente");
        JButton jbBorrarCliente = new JButton("Borrar Cliente");
        JButton jbRecuperarCliente = new JButton("Recuperar Cliente");
        JButton jbListarClientes = new JButton("Listar Clientes");
        JButton jbClientesFecha = new JButton("Listar Clientes entre fechas");
        JButton jbCambiarTarifa = new JButton("Cambiar Tarifa");
        jbAnyadirCliente.addActionListener(escuchadorClientes);
        jbBorrarCliente.addActionListener(escuchadorClientes);
        jbRecuperarCliente.addActionListener(escuchadorClientes);
        jbListarClientes.addActionListener(escuchadorClientes);
        jbClientesFecha.addActionListener(escuchadorClientes);
        jbCambiarTarifa.addActionListener(escuchadorClientes);
        clientesPestanya.add(jbAnyadirCliente);
        clientesPestanya.add(jbBorrarCliente);
        clientesPestanya.add(jbRecuperarCliente);
        clientesPestanya.add(jbListarClientes);
        clientesPestanya.add(jbCambiarTarifa);
        clientesPestanya.add(jbClientesFecha);
        EscuchadorFacturas escuchadorFacturas=new EscuchadorFacturas();
        JButton jbEmitirFactura = new JButton("Emitir Factura");
        JButton jbRecuperarFactura = new JButton("Recuperar Factura");
        JButton jbListarFacturas = new JButton("Listar Facturas");
        JButton jbFacturasFechas = new JButton("Facturas entre fechas");
        jbEmitirFactura.addActionListener(escuchadorFacturas);
        jbRecuperarFactura.addActionListener(escuchadorFacturas);
        jbListarFacturas.addActionListener(escuchadorFacturas);
        jbFacturasFechas.addActionListener(escuchadorFacturas);
        facturasPestanya.add(jbEmitirFactura);
        facturasPestanya.add(jbRecuperarFactura);
        facturasPestanya.add(jbListarFacturas);
        facturasPestanya.add(jbFacturasFechas);
        EscuchadorLlamadas escuchadorLlamadas=new EscuchadorLlamadas();
        JButton jbAnyadirLlamada = new JButton("Añadir Llamada");
        JButton jbListarLlamadas = new JButton("Mostrar Llamadas");
        JButton jbLlamadasFechas = new JButton("Llamadas entre fechas");
        jbAnyadirLlamada.addActionListener(escuchadorLlamadas);
        jbListarLlamadas.addActionListener(escuchadorLlamadas);
        jbLlamadasFechas.addActionListener(escuchadorLlamadas);
        llamadasPestanya.add(jbAnyadirLlamada);
        llamadasPestanya.add(jbListarLlamadas);
        llamadasPestanya.add(jbLlamadasFechas);
        contenedor.add(pestanyas);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    class EscuchadorClientes implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton)e.getSource();
            String texto = boton.getText();
            if(texto.equals("Añadir Cliente"))
            else if(texto.equals("Borrar Cliente"))
            else if(texto.equals("Recuperar Cliente"))
            else if(texto.equals("Listar Clientes"))
            else if(texto.equals("Listar Clientes entre fechas"))
            else if(texto.equals("Cambiar Tarifa"))
        }
    }

    class EscuchadorFacturas implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton)e.getSource();
            String texto = boton.getText();
            if(texto.equals("Emitir Factura"))
            else if(texto.equals("Recuperar Factura"))
            else if(texto.equals("Listar Facturas"))
            else if(texto.equals("Facturas entre fechas"))

        }
    }

    class EscuchadorLlamadas implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton)e.getSource();
            String texto = boton.getText();
            if(texto.equals("Añadir Llamada"))
            else if(texto.equals("Mostrar Llamadas"))
            else if(texto.equals("Llamadas entre fechas"))

        }
    }

}
