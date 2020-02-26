import java.util.HashMap;
import java.util.HashSet;
import java.time.LocalDate;
import java.time.LocalTime;

public class gestionClientes {
    protected HashMap<String, HashSet<Llamada>> llamadas;
    private HashMap<String, HashSet<Factura>> facturas;
    private HashMap<String, Cliente> clientes;
    private HashMap<Integer, Factura> codFacturas;

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

    public void cambiarTarifa(Cliente cliente, int tarifa){
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

    public HashSet<Llamada> listadoLlamadas(Cliente cliente){
        return llamadas.get(cliente.getNIF());
    }

    public void emitirFacturaUltimoMes(Cliente cliente){
        LocalDate fechaHoy=LocalDate.now();
        Factura factura=new Factura(cliente.getTarifa(),fechaHoy, fechaHoy.minusMonths(1).minusDays(fechaHoy.getDayOfMonth()), fechaHoy.minusDays(fechaHoy.getDayOfMonth()));
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
