package mvc.vista;
import mvc.controlador.*;
import mvc.modelo.InterrogaModelo;
import mvc.vista.pestanaClientes.*;
import mvc.vista.pestanaFacturas.VentanaEmitirFactura;
import mvc.vista.pestanaFacturas.VentanaFacturasEntreFechas;
import mvc.vista.pestanaFacturas.VentanaMostrarFacturas;
import mvc.vista.pestanaFacturas.VentanaRecuperarFactura;
import mvc.vista.pestañaLlamadas.VentanaLlamadasEntreFechas;
import mvc.vista.pestañaLlamadas.VentanaMostrarLlamadas;
import mvc.vista.pestañaLlamadas.VentanaNuevaLlamada;
import mvc.vista.tabla.VentanaTabla;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class VentanaInicial implements InformarVista,InterrogaVista{

    Controlador controlador;
    InterrogaModelo modelo;
    ArrayList<VentanaTabla> tablasEmergentes;

    public VentanaInicial() {
        tablasEmergentes = new ArrayList<>();
    }

    public void setModelo(InterrogaModelo modelo){
        this.modelo=modelo;
    }
    private void GUI() {
        JFrame ventana = new JFrame("Aplicación Telefonía");
        Container contenedor = ventana.getContentPane();

        // Creación de pestañas para la ventana principal
        JTabbedPane pestanyas = new JTabbedPane();
        JPanel clientesPestanya=new JPanel();
        JPanel facturasPestanya=new JPanel();
        JPanel llamadasPestanya=new JPanel();
        pestanyas.add("Clientes", clientesPestanya);
        pestanyas.add("Facturas", facturasPestanya);
        pestanyas.add("Llamadas", llamadasPestanya);

        //Opciones de las pestañas para clientes
        EscuchadorClientes escuchadorClientes=new EscuchadorClientes();
        JButton jbAnyadirCliente = new JButton("Añadir Cliente");
        JButton jbBorrarCliente = new JButton("Borrar Cliente");
        JButton jbRecuperarCliente = new JButton("Recuperar Cliente");
        JButton jbListarClientes = new JButton("Listar Clientes");
        JButton jbClientesFecha = new JButton("Listar Clientes entre fechas");
        JButton jbCambiarTarifa = new JButton("Cambiar Tarifa");

        jbAnyadirCliente.setActionCommand("nuevo");
        jbBorrarCliente.setActionCommand("borrar");
        jbRecuperarCliente.setActionCommand("recuperar");
        jbListarClientes.setActionCommand("listarcli");
        jbClientesFecha.setActionCommand("listarFechas");
        jbCambiarTarifa.setActionCommand("tarifa");

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

        //Opciones de la pestaña para facturas
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

        //Opciones de la pestaña para llamadas
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
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "nuevo":
                    anyadirCliente();
                    break;
                case "borrar":
                    borrarCliente();
                    break;
                case "recuperar":
                    recuperarCliente();
                    break;
                case "listarcli":
                    listarClientes();
                    break;
                case "listarFechas":
                    clientesEntreFechas();
                    break;
                case "tarifa":
                    cambiarTarifa();
                    break;

            }
        }
    }

    class EscuchadorFacturas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Emitir Factura":
                    emitirFactura();
                    break;
                case "Recuperar Factura":
                    recuperarFactura();
                    break;
                case "Listar Facturas":
                    mostraFacturas();
                    break;
                case "Facturas entre fechas":
                    mostrarFacturasEntreFechas();
                    break;
            }
        }
    }

    class EscuchadorLlamadas implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Añadir Llamada":
                    anadirLlamada();
                    break;
                case "Mostrar Llamadas":
                    mostrarLlamadas();
                    break;
                case "Llamadas entre fechas":
                    mostrarLlamadasEntreFechas();
                    break;
            }
        }
    }
    private void anyadirCliente(){
        VentanaClienteNuevo ventana = new VentanaClienteNuevo(controlador);
        ventana.creaGUI();
    }
    private void borrarCliente(){

        VentanaBorrar ventana= new VentanaBorrar(controlador);
        ventana.creaGUI();
    }

    public void setControlador(Controlador controlador){
        this.controlador=controlador;
    }

    private void listarClientes(){
            AbstractTableModel modeloTabla = modelo.listarClientes();
            VentanaTabla ventana = new VentanaTabla();
            SwingUtilities.invokeLater(() -> ventana.GUI(modeloTabla));

            //Guardamos las ventanas que abrimos para saber que ventanas tenemos
            //que actualizar cuando cambie el modelo
            tablasEmergentes.add(ventana);
    }

    private void recuperarCliente(){
        VentanaRecuperarCliente ventana = new VentanaRecuperarCliente(modelo);
        ventana.creaGUI();
    }

    private void cambiarTarifa(){
        VentanaCambiarTarifa ventana = new VentanaCambiarTarifa(controlador);
        ventana.creaGUI();
    }

    private void clientesEntreFechas(){
        VentanaClientesEntreFechas ventana = new VentanaClientesEntreFechas(modelo);
        ventana.creaGUI();
    }

    private void anadirLlamada(){
        VentanaNuevaLlamada ventana = new VentanaNuevaLlamada(controlador);
        ventana.creaGUI();
    }

    private void mostrarLlamadas(){
        VentanaMostrarLlamadas ventana = new VentanaMostrarLlamadas(modelo);
        ventana.creaGUI();
    }

    private void mostrarLlamadasEntreFechas(){
        VentanaLlamadasEntreFechas ventana = new VentanaLlamadasEntreFechas(modelo);
        ventana.creaGUI();
    }

    private void emitirFactura(){
        VentanaEmitirFactura ventana = new VentanaEmitirFactura(controlador);
        ventana.creaGUI();
    }

    private void recuperarFactura(){
        VentanaRecuperarFactura ventana = new VentanaRecuperarFactura(modelo);
        ventana.creaGUI();
    }

    private  void mostraFacturas(){
        VentanaMostrarFacturas ventana = new VentanaMostrarFacturas(modelo);
        ventana.creaGUI();
    }

    private void mostrarFacturasEntreFechas(){
        VentanaFacturasEntreFechas ventana = new VentanaFacturasEntreFechas(modelo);
        ventana.creaGUI();
    }

    public void actualizar(AbstractTableModel modelo){
        for (VentanaTabla tabla : tablasEmergentes){
            tabla.actualizarTabla(modelo);
        }
    }
}
