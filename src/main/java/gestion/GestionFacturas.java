package gestion;

import data.cliente.Cliente;
import data.facturas.Factura;
import data.llamada.Llamada;
import gestion.excepciones.FacturaNotFoundException;
import gestion.excepciones.ListaDeFacturasVaciaException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

class GestionFacturas implements Serializable {

    private HashMap<Integer, Factura> codFacturas;
    private HashMap<String, HashSet<Factura>> facturas;

    GestionFacturas() {
        this.codFacturas = new HashMap<>();
        this.facturas=new HashMap<>();
    }

    void borrarFacturas(String NIF){
        HashSet<Factura> facturasCliente = facturas.get(NIF);
        if (facturasCliente != null) {
            for (Factura factura : facturasCliente) {
                codFacturas.remove(factura.getCodigo());
            }
            facturas.remove(NIF);
        }
    }

    void emitirFactura(Cliente cliente, LocalDate fechaInicial, LocalDate fechaFinal, double importe) throws IllegalArgumentException{
        if (fechaFinal.compareTo(fechaInicial) <= 0)
            throw new IllegalArgumentException("La fecha inicial no puede ser posterior a la final");
        LocalDate fechaHoy = LocalDate.now();
        Factura factura = new Factura(cliente.getTarifa(), fechaHoy, fechaInicial, fechaFinal, importe);
        anadirFactura(cliente, factura);
    }

    double calcularImporte(Cliente cliente, HashSet<Llamada> llamadasRealizadas){
        double sumaImporte = 0;
        for(Llamada llamada: llamadasRealizadas){

            sumaImporte += llamada.getDuracion()*cliente.getTarifa().getPrecio(llamada);
        }
        return sumaImporte;
    }

    private void anadirFactura(Cliente cliente, Factura nuevaFactura){
        if (facturas.get(cliente) == null)
            facturas.put(cliente.getNIF(), new HashSet<>());
        facturas.get(cliente.getNIF()).add(nuevaFactura);
        codFacturas.put(nuevaFactura.getCodigo(), nuevaFactura);
    }

    Factura recuperarFactura(int cod) throws FacturaNotFoundException {
        Factura factura = codFacturas.get(cod);
        if (factura == null) throw new FacturaNotFoundException();
        return codFacturas.get(cod);
    }

    HashSet<Factura> listarFacturas(Cliente cliente) throws ListaDeFacturasVaciaException {
        HashSet<Factura> listado = facturas.get(cliente.getNIF());
        if (listado.isEmpty()) throw new ListaDeFacturasVaciaException();
        return listado;
    }
}
