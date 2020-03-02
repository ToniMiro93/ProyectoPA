package baseDeDatos;

import java.util.HashMap;
import java.util.HashSet;
import java.time.LocalDate;

public class gestionClientes {
    private HashMap<String, HashSet<Llamada>> llamadas;
    private HashMap<String, HashSet<Factura>> facturas;
    private HashMap<String, Cliente> clientes;
    private HashMap<Integer, Factura> codFacturas;

    public gestionClientes(){
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

    public void cambiarTarifa(Cliente cliente, int tarifa){
        cliente.setTarifa(tarifa);
    }

    public Cliente datosCliente(String NIF){
        return clientes.get(NIF);
    }

    public HashSet<Cliente> listadoClientes(){
        HashSet<Cliente> lista = new HashSet<>();
        int i = 0;
        for (String NIF : clientes.keySet()){
            lista.add(clientes.get(NIF));
        }
        return lista;
    }

    public void anadirLlamada(Cliente cliente, Llamada llamada){
        llamadas.get(cliente.getNIF()).add(llamada);
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }
    public HashMap<Integer, Factura> getCodFacturas() {
        return codFacturas;
    }

    public HashMap<String, HashSet<Factura>> getFacturas() {
        return facturas;
    }

    public HashSet<Llamada> listadoLlamadas(Cliente cliente){
        return llamadas.get(cliente.getNIF());
    }

    public void emitirFactura(Cliente cliente, LocalDate fechaInicial, LocalDate fechaFinal){
        LocalDate fechaHoy=LocalDate.now();
        Factura factura=new Factura(cliente.getTarifa(),fechaHoy, fechaInicial, fechaFinal);
        factura.setImporte(calcularImporte(factura, cliente));
        codFacturas.put(factura.getCodigo(), factura);
        facturas.get(cliente.getNIF()).add(factura);


    }
    private double calcularImporte(Factura factura,Cliente cliente){
        double sumaImporte=0;
        for(Llamada llamada:llamadas.get(cliente.getNIF())){
            if (llamada.getFecha().compareTo(factura.getInicioPeriodo())>=0 && llamada.getFecha().compareTo(factura.getFinalPeriodo())<=0){
                sumaImporte += llamada.getDuracion()*cliente.getTarifa().getEurosMinuto();
            }
        }
        return sumaImporte;
    }
    public String recuperarFactura(int cod){
        return codFacturas.get(cod).toString();
    }
    public HashSet<Factura> recuperarFacturas (Cliente cliente){
        return facturas.get(cliente.getNIF());
    }

}
