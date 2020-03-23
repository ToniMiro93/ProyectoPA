package gestion;

import data.Fecha;
import data.cliente.Cliente;
import data.cliente.datos.Tarifa;
import data.facturas.Factura;
import data.llamada.Llamada;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;

public class Gestion implements Serializable{

    private GestionClientes gestorClientes;
    private GestionFacturas gestorFacturas;

    public Gestion() {
        this.gestorClientes = new GestionClientes();
        this.gestorFacturas = new GestionFacturas();
    }

    public void anadirCliente(Cliente nuevoCliente){
        gestorClientes.nuevoCliente(nuevoCliente);
    }

    public void borrarCliente(String NIF){
        gestorClientes.borrarCliente(NIF);
        gestorFacturas.borrarFacturas(NIF);
    }

    public void cambiarTarifa(Cliente cliente, Tarifa tarifa){
        gestorClientes.cambiarTarifa(cliente, tarifa);
    }

    // @todo
    // XXX: hay que juntar el recuperar de Clientes y Facturas
    public Cliente recuperarCliente(String NIF){
        return gestorClientes.datosCliente(NIF);
    }

    // @todo
    // XXX: hay que juntar todos los listar de clientes, facturas y llamadas
    public HashSet<Cliente> listarClientes(){
        return gestorClientes.listadoClientes();
    }

    public void anadirLlamada(Cliente cliente, Llamada nuevaLlamada){
        gestorClientes.anadirLlamada(cliente, nuevaLlamada);
    }

    public HashSet<Llamada> listarLlamadas(Cliente cliente){
        return gestorClientes.listadoLlamadas(cliente);
    }

    public void emitirFactura(Cliente cliente, LocalDate fechaInicial, LocalDate fechaFinal){
        HashSet<Llamada> llamadasRealizadas = Utilidades.filtrarElementosEntreFechas(gestorClientes.listadoLlamadas(cliente), fechaInicial, fechaFinal);
        double importe = gestorFacturas.calcularImporte(cliente, llamadasRealizadas);
        gestorFacturas.emitirFactura(cliente, fechaInicial, fechaFinal, importe);
    }

    public Factura recuperarFactura(int cod){
        return gestorFacturas.recuperarFactura(cod);
    }

    public HashSet<Factura> listarFacturas(Cliente cliente){
        return gestorFacturas.listarFacturas(cliente);
    }

    public <T extends Fecha> HashSet<T> getDatosEntreFechas(HashSet<T> conjunto, LocalDate fechaInicial, LocalDate fechaFinal) {
        return Utilidades.filtrarElementosEntreFechas(conjunto, fechaInicial, fechaFinal);
    }
}
