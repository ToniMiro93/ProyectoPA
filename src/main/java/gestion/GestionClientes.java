package gestion;

import data.clientes.Cliente;
import data.clientes.datos.Tarifa;
import data.llamadas.Llamada;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class GestionClientes implements Serializable {
    protected HashMap<String, HashSet<Llamada>> llamadas;
    protected HashMap<String, Cliente> clientes;


    protected GestionClientes(){
        llamadas=new HashMap<>();
        clientes=new HashMap<>();
    }

    protected void nuevoCliente(Cliente cliente){
        clientes.put(cliente.getNIF(), cliente);
        llamadas.put(cliente.getNIF(), new HashSet<>());
    }

    protected void borrarCliente(String NIF) {
        clientes.remove(NIF);
        llamadas.remove(NIF);

    }

    protected void cambiarTarifa(Cliente cliente, Tarifa tarifa){
        cliente.setTarifa(tarifa);
    }

    protected Cliente datosCliente(String NIF){
        return clientes.get(NIF);
    }

    protected HashSet<Cliente> listadoClientes(){
        HashSet<Cliente> lista = new HashSet<>();
        int i = 0;
        for (String NIF : clientes.keySet()){
            lista.add(clientes.get(NIF));
        }
        return lista;
    }

    protected void anadirLlamada(Cliente cliente, Llamada llamada){
        llamadas.get(cliente.getNIF()).add(llamada);
    }

    protected HashSet<Llamada> listadoLlamadas(Cliente cliente){
        return llamadas.get(cliente.getNIF());
    }

}
