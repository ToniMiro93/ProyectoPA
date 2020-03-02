package gestion;

import baseDeDatos.clientes.Cliente;
import baseDeDatos.clientes.datos.Tarifa;
import baseDeDatos.facturas.Factura;
import baseDeDatos.llamadas.Llamada;

import java.time.LocalDate;
import java.util.HashSet;

public class Gestion {
    private GestionClientes gestorClientes;
    private GestionFacturas gestorFacturas;

    public Gestion() {
        this.gestorClientes = new GestionClientes();
        this.gestorFacturas = new GestionFacturas();
    }

    public void anadirCliente(Cliente cliente){
        gestorClientes.nuevoCliente(cliente);
    }

    public void borrarCliente(String NIF){
        gestorClientes.borrarCliente(NIF);
        gestorFacturas.borrarFacturas(NIF);
    }

    public void cambiarTarifa(Cliente cliente, Tarifa tarifa){
        gestorClientes.cambiarTarifa(cliente, tarifa);
    }

    public Cliente recuperarCliente(String NIF){
        return gestorClientes.datosCliente(NIF);
    }

    public HashSet<Cliente> listarClientes(){
        return gestorClientes.listadoClientes();
    }

    public void anadirLlamada(Cliente cliente, Llamada llamada){
        gestorClientes.anadirLlamada(cliente, llamada);
    }

    public HashSet<Llamada> listarLlamadas(Cliente cliente){
        return gestorClientes.listadoLlamadas(cliente);
    }

    public void emitirFactura(Cliente cliente, LocalDate fechaInicial, LocalDate fechaFinal){
        gestorFacturas.emitirFactura(cliente, fechaInicial, fechaFinal);
    }

    public Factura recuperarFactura(int cod){
        return gestorFacturas.recuperarFactura(cod);
    }

    public HashSet<Factura> listarFacturas(Cliente cliente){
        return gestorFacturas.listarFacturas(cliente);
    }

}
