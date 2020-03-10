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

    public <T extends Fecha> HashSet<T> getDatosEntreFechas(HashSet<T> conjunto, LocalDate fechaInicial, LocalDate fechaFinal) {
        HashSet<T> nuevoConjunto= new HashSet<T>();
        for(T objeto: conjunto){
            if (objeto.getFecha().compareTo(fechaInicial)>=0 && objeto.getFecha().compareTo(fechaFinal)<=0)
                nuevoConjunto.add(objeto);
        }
        return nuevoConjunto;
    }

    private <T> String convertHashToString(HashSet<T> conjunto){
        String resultado = null;
        for (T elemento : conjunto)
            resultado = resultado + elemento.toString() + "\n";
        return resultado;
    }
}
