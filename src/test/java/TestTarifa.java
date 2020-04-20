import data.cliente.Cliente;
import data.facturas.Factura;
import data.llamada.Llamada;
import gestion.Gestion;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestTarifa {

    @Test
    public void testTarifaBase(){
        Gestion gestion = new Gestion();
        Cliente cliente = testSetUp.crearCliente();
        gestion.anadirCliente(cliente);

        //Usamos un constructor provisional para crear la llamada y controlar la fecha y hora
        LocalDate fecha = LocalDate.of(2020, 4, 19);
        LocalTime hora = LocalTime.of(17,00);
        Llamada llamada = new Llamada(1, fecha, hora);
        gestion.anadirLlamada(cliente, llamada);

        // Creamos la factura y nos guardamos su importe
        gestion.emitirFactura(cliente, LocalDate.of(2020,3,1),
                LocalDate.of(2020,5,1));
        Factura factura = gestion.recuperarFactura(0);
        double importe = factura.getImporte();
        assertThat(importe, is((double) 15));
    }

    public void testTarifaTardes(){
        Gestion gestion = new Gestion();
        Cliente cliente = testSetUp.crearCliente();
        gestion.anadirCliente(cliente);


        //Usamos un constructor provisional para crear la llamada y controlar la fecha y hora
        LocalDate fecha = LocalDate.of(2020, 4, 19);
        LocalTime hora = LocalTime.of(17,00);
        Llamada llamada = new Llamada(1, fecha, hora);
        gestion.anadirLlamada(cliente, llamada);

        // Creamos la factura y nos guardamos su importe
        gestion.emitirFactura(cliente, LocalDate.of(2020,3,1),
                LocalDate.of(2020,5,1));
        Factura factura = gestion.recuperarFactura(0);
        double importe = factura.getImporte();
        assertThat(importe, is((double) 15));
    }
}
