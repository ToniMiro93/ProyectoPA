import java.util.HashMap;
import java.util.HashSet;

public class gestionClientes {
    protected HashMap<String, HashSet<Llamada>> llamadas;
    private HashMap<String, HashSet<Factura>> facturas;
    private HashMap<String, Cliente> clientes;

    gestionClientes(){
        llamadas=new HashMap<>();
        facturas=new HashMap<>();
        clientes=new HashMap<>();
    }

    public void nuevoCliente(Cliente cliente){
        clientes.put(cliente.getNIF(), cliente);
        llamadas.put(cliente.getNIF(), new HashSet<>());
        facturas.put(cliente.getNIF(), new HashSet<>());
    }

    public void borrarCliente(Cliente cliente) {
        clientes.remove(cliente.getNIF());
        llamadas.remove(cliente.getNIF());
        facturas.remove(cliente.getNIF());
    }

    public void cambiarTarifa(Cliente cliente, Tarifa tarifa){
        cliente.setTarifa(tarifa);
    }

    public String datosCliente(String NIF){
        Cliente cliente = clientes.get(NIF);
        return cliente.toString();
    }

    public Cliente[] listadoClientes(){
        Cliente[] lista = new Cliente[clientes.size()];
        int i = 0;
        for (String NIF : clientes.keySet()){
            lista[i++] = clientes.get(NIF);
        }
        return lista;
    }

    public void anadirLlamada(Cliente cliente, Llamada llamada){
        llamadas.get(cliente.getNIF()).add(llamada);
    }

    public Llamada[] listadoLlamadas(Cliente cliente){
        Llamada[] lista = new Llamada[llamadas.get(cliente.getNIF()).size()];
        int i = 0;
        for (Llamada llamada : llamadas.get(cliente.getNIF())){
            lista[i++] = llamada;
        }
        return lista;
    }

//    public void emitirFacura(Cliente cliente,)
}
