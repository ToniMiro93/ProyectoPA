package mvc.modelo;

import data.cliente.Cliente;
import data.cliente.datos.Direccion;
import data.facturas.Factura;
import data.llamada.Llamada;
import data.tarifas.Tarifa;
import gestion.fabricas.Fabrica;
import gestion.fabricas.FabricaClientes;
import gestion.*;
import gestion.fabricas.FabricaTarifas;
import mvc.modelo.tablas.ModeloTablaClientes;
import mvc.modelo.tablas.ModeloTablaFacturas;
import mvc.modelo.tablas.ModeloTablaLlamadas;
import mvc.vista.InformarVista;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class Modelo implements ActualizaModelo, InterrogaModelo{
    Gestion gestor=new Gestion();
    InformarVista vista;


    public void setVista(InformarVista vista) {
        this.vista = vista;

    }

    public void crearCliente(String nombre,String apellidos,String nif, String email, String poblacion, String provincia, int cp){

        // Creamos el connstructor de cliente
        FabricaClientes fabricaCliente= new FabricaClientes();

        // Se crea el tipo de cliente que se necesite.
        Direccion direccion = new Direccion(cp,provincia,poblacion);
        Cliente cliente = apellidos==null ? fabricaCliente.getClienteEmpresa(nombre,nif,email,direccion): fabricaCliente.getClienteParticular(nombre,nif,email,direccion,apellidos);

        // Se incorpora
        gestor.anadirCliente(cliente);
        vista.actualizar(listarClientes());
    }

    public void borrarCliente(String dni){
        gestor.borrarCliente(dni);
        vista.actualizar(listarClientes());
    }

    public AbstractTableModel listarClientes(){

        //Creación de un ArrayList para entregarlo al modelo de las tablas en cuestion.
        ArrayList<Cliente> clientes=new ArrayList<>();

        //La lista se completa con los elementos del conjunto devuelto por nuestro gestor
        clientes.addAll(gestor.listarClientes());

        //Se devuelve a Vista el modelo para crear una tabla en la interfaz grafica
        return new ModeloTablaClientes(clientes);

    }


    public AbstractTableModel clientesEntreFechas(LocalDate fechaInicio, LocalDate fechaFin){
        ArrayList<Cliente> clientes=new ArrayList<>();
        clientes.addAll(gestor.getDatosEntreFechas(gestor.listarClientes(),fechaInicio,fechaFin));
        return new ModeloTablaClientes(clientes);
    }

    @Override
    public AbstractTableModel recuperarCliente(String nif) {
        ArrayList<Cliente> cliente = new ArrayList<>();
        cliente.add(gestor.recuperarCliente(nif));
        return new ModeloTablaClientes(cliente);
    }

    @Override
    public void cambiarTarifa(String nif, String tarifaElegida) {
        Cliente cliente = gestor.recuperarCliente(nif);
        FabricaTarifas fabrica = new FabricaTarifas();
        Tarifa tarifa = fabrica.getTarifaDomingos(cliente.getTarifa());
        switch (tarifaElegida){
            case "Tarifa Tardes":
                tarifa = fabrica.getTarifaTardes(cliente.getTarifa());
                break;
        }
        gestor.cambiarTarifa(cliente, tarifa);
    }

    @Override
    public void anadirLLamada(String nif, long num, int dur) {
        Llamada llamada = new Llamada(num, dur);
        gestor.anadirLlamada(gestor.recuperarCliente(nif), llamada);
    }

    @Override
    public AbstractTableModel mostrarLlamadas(String nif) {
        ArrayList<Llamada> llamadas = new ArrayList<>();
        llamadas.addAll(gestor.listarLlamadas(gestor.recuperarCliente(nif)));
        return new ModeloTablaLlamadas(llamadas);
    }

    @Override
    public AbstractTableModel llamadasEntreFechas(String nif, LocalDate fechaInicio, LocalDate fechaFin) {
        ArrayList<Llamada> llamadas = new ArrayList<>();
        llamadas.addAll(gestor.getDatosEntreFechas(gestor.listarLlamadas(gestor.recuperarCliente(nif)),
                fechaInicio, fechaFin));
        return new ModeloTablaLlamadas(llamadas);
    }

    @Override
    public void emitirfactura(String nif, LocalDate fechaInicial, LocalDate fechaFin) {
        gestor.emitirFactura(gestor.recuperarCliente(nif), fechaInicial, fechaFin);
    }

    @Override
    public AbstractTableModel recuperarFactura(int codigo) {
        ArrayList<Factura> factura = new ArrayList<>();
        factura.add(gestor.recuperarFactura(codigo));
        return new ModeloTablaFacturas(factura);
    }

    @Override
    public AbstractTableModel mostrarFacturas(String nif) {
        ArrayList<Factura> facturas = new ArrayList<>();
        facturas.addAll(gestor.listarFacturas(gestor.recuperarCliente(nif)));
        return new ModeloTablaFacturas(facturas);
    }

    @Override
    public AbstractTableModel facturasEntreFechas(String nif, LocalDate fechaInicio, LocalDate fechaFin) {
        ArrayList<Factura> facturas = new ArrayList<>();
        facturas.addAll(gestor.getDatosEntreFechas(gestor.listarFacturas(gestor.recuperarCliente(nif)),
                fechaInicio, fechaFin));
        return new ModeloTablaFacturas(facturas);
    }

}
