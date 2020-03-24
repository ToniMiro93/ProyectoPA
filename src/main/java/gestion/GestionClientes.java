package gestion;

import data.cliente.Cliente;
import data.cliente.datos.Tarifa;
import data.llamada.Llamada;
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

    void borrarCliente(String NIF) {
        clientes.remove(NIF);
        llamadas.remove(NIF);
    }

    void cambiarTarifa(Cliente cliente, Tarifa tarifa){
        cliente.setTarifa(tarifa);
    }

    Cliente datosCliente(String NIF){
        return clientes.get(NIF);
    }

    HashSet<Cliente> listadoClientes(){
        HashSet<Cliente> lista = new HashSet<>();
        for (String NIF : clientes.keySet()){
            lista.add(clientes.get(NIF));
        }
        return lista;
    }

    void anadirLlamada(Cliente cliente, Llamada nuevaLlamada){
        llamadas.get(cliente.getNIF()).add(nuevaLlamada);
    }

    HashSet<Llamada> listadoLlamadas(Cliente cliente){
        return llamadas.get(cliente.getNIF());
    }

}
