package gestion;

import data.Fecha;
import data.cliente.Cliente;
import data.tarifas.Tarifa;
import data.facturas.Factura;
import data.llamada.Llamada;
import gestion.excepciones.*;

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
        try {
            gestorClientes.borrarCliente(NIF);
            gestorFacturas.borrarFacturas(NIF);
        }
        catch (ClienteNotFoundException e){
            e.printStackTrace();
        }
    }

    public void cambiarTarifa(Cliente cliente, Tarifa tarifa){
        gestorClientes.cambiarTarifa(cliente, tarifa);
    }

    public Cliente recuperarCliente(String NIF){
        try {
            return gestorClientes.datosCliente(NIF);
        }
        catch (ClienteNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public HashSet<Cliente> listarClientes(){
        try {
            return gestorClientes.listadoClientes();
        }
        catch (ListaDeClientesVaciaException e){
            e.printStackTrace();
            return new HashSet<Cliente>();
        }
    }

    public void anadirLlamada(Cliente cliente, Llamada nuevaLlamada){
        gestorClientes.anadirLlamada(cliente, nuevaLlamada);
    }

    public HashSet<Llamada> listarLlamadas(Cliente cliente){
        try {
            return gestorClientes.listadoLlamadas(cliente);
        }
        catch (ListaDeLlamadasVaciaException e){
            e.printStackTrace();
            return new HashSet<Llamada>();
        }
    }

    public void emitirFactura(Cliente cliente, LocalDate fechaInicial, LocalDate fechaFinal){
        try {
            HashSet<Llamada> llamadasRealizadas = Utilidades.filtrarElementosEntreFechas(gestorClientes.listadoLlamadas(cliente), fechaInicial, fechaFinal);
            double importe = gestorFacturas.calcularImporte(cliente, llamadasRealizadas);
            gestorFacturas.emitirFactura(cliente, fechaInicial, fechaFinal, importe);
        }
        catch (ListaDeLlamadasVaciaException e){
            e.printStackTrace();
            gestorFacturas.emitirFactura(cliente, fechaInicial, fechaFinal, 0);
        }
        catch (ElementosNoEncontradosException e){
            e.printStackTrace();
            gestorFacturas.emitirFactura(cliente, fechaInicial, fechaFinal, 0);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public Factura recuperarFactura(int cod){
        try {
            return gestorFacturas.recuperarFactura(cod);
        }
        catch (FacturaNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public HashSet<Factura> listarFacturas(Cliente cliente){
        try {
            return gestorFacturas.listarFacturas(cliente);
        }
        catch (ListaDeFacturasVaciaException e){
            e.printStackTrace();
            return new HashSet<Factura>();
        }
    }

    public <T extends Fecha> HashSet<T> getDatosEntreFechas(HashSet<T> conjunto, LocalDate fechaInicial, LocalDate fechaFinal) {
        try {
            return Utilidades.filtrarElementosEntreFechas(conjunto, fechaInicial, fechaFinal);
        }
        catch (ElementosNoEncontradosException e){
            e.printStackTrace();
            return null;
        }
    }
}
