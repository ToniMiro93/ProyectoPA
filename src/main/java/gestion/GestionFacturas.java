package gestion;

import data.cliente.Cliente;
import data.facturas.Factura;
import data.llamada.Llamada;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class GestionFacturas implements Serializable {
    protected HashMap<Integer, Factura> codFacturas;
    protected HashMap<String, HashSet<Factura>> facturas;

    protected GestionFacturas() {
        this.codFacturas = new HashMap<>();
        this.facturas=new HashMap<>();
    }

    protected void borrarFacturas(String NIF){
        HashSet<Factura> facturasCliente = facturas.get(NIF);
        if (facturasCliente != null) {
            for (Factura factura : facturasCliente) {
                codFacturas.remove(factura.getCodigo());
            }
            facturas.remove(NIF);
        }
    }

    protected void emitirFactura(Cliente cliente, LocalDate fechaInicial, LocalDate fechaFinal){
        LocalDate fechaHoy = LocalDate.now();
        Factura factura = new Factura(cliente.getTarifa(), fechaHoy, fechaInicial, fechaFinal);
        factura.setImporte(calcularImporte(factura, cliente));
        anadirFactura(cliente, factura);
    }

    private double calcularImporte(Factura factura,Cliente cliente){
        double sumaImporte = 0;
        for(Llamada llamada: cliente.getLlamadas()){
            if (llamada.getFecha().compareTo(factura.getInicioPeriodo())>=0 && llamada.getFecha().compareTo(factura.getFinalPeriodo())<=0){
                sumaImporte += llamada.getDuracion()*cliente.getTarifa().getEurosMinuto();
            }
        }
        return sumaImporte;
    }

    private void anadirFactura(Cliente cliente, Factura factura){
        if (facturas.get(cliente) == null)
            facturas.put(cliente.getNIF(), new HashSet<>());
        facturas.get(cliente.getNIF()).add(factura);
        codFacturas.put(factura.getCodigo(), factura);
    }

    protected Factura recuperarFactura(int cod){
        return codFacturas.get(cod);
    }

    protected HashSet<Factura> listarFacturas(Cliente cliente){
        return facturas.get(cliente.getNIF());
    }
}
