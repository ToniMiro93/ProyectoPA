package gestion;

import data.cliente.Cliente;
import data.tarifas.Tarifa;
import data.llamada.Llamada;
import gestion.excepciones.ClienteNotFoundException;
import gestion.excepciones.ListaDeClientesVaciaException;
import gestion.excepciones.ListaDeLlamadasVaciaException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

class GestionClientes implements Serializable {

    private HashMap <String, HashSet<Llamada>> llamadas;
    private HashMap <String, Cliente> clientes;


    GestionClientes(){
        llamadas=new HashMap<>();
        clientes=new HashMap<>();
    }

    void nuevoCliente(Cliente nuevoCliente){
        clientes.put(nuevoCliente.getNIF(), nuevoCliente);
        llamadas.put(nuevoCliente.getNIF(), new HashSet<>());
    }

    void borrarCliente(String NIF) throws ClienteNotFoundException {
        if (clientes.remove(NIF) == null) throw new ClienteNotFoundException();
        llamadas.remove(NIF);
    }

    void cambiarTarifa(Cliente cliente, Tarifa tarifa) {
        cliente.setTarifa(tarifa);
    }

    Cliente datosCliente(String NIF) throws ClienteNotFoundException {
        Cliente cliente = clientes.get(NIF);
        if (cliente == null) throw new ClienteNotFoundException();
        return cliente;
    }

    HashSet<Cliente> listadoClientes() throws ListaDeClientesVaciaException {
        HashSet<Cliente> lista = new HashSet<>();
        for (String NIF : clientes.keySet()){
            lista.add(clientes.get(NIF));
        }
        if (lista.isEmpty()) throw new ListaDeClientesVaciaException();
        return lista;
    }

    void anadirLlamada(Cliente cliente, Llamada nuevaLlamada){
        llamadas.get(cliente.getNIF()).add(nuevaLlamada);
    }

    HashSet<Llamada> listadoLlamadas(Cliente cliente) throws ListaDeLlamadasVaciaException {
        HashSet<Llamada> listado = llamadas.get(cliente.getNIF());
        if (listado.isEmpty()) throw new ListaDeLlamadasVaciaException();
        return listado;
    }

}
