import data.cliente.Cliente;
import data.facturas.Factura;
import data.llamada.Llamada;
import gestion.Gestion;
import gestion.fabricas.FabricaTarifasParametrizada;
import gestion.fabricas.TipoTarifa;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestTarifa {
    private static int cod;
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
        Factura factura = gestion.recuperarFactura(cod++);
        double importe = factura.getImporte();
        assertThat(importe, is((double) 15));
    }

    @Test
    public void testTarifaTardes(){
        Gestion gestion = new Gestion();
        Cliente cliente = testSetUp.crearCliente();
        gestion.anadirCliente(cliente);
        FabricaTarifasParametrizada fabrica = new FabricaTarifasParametrizada();
        TipoTarifa tipo = TipoTarifa.TARDES;
        gestion.cambiarTarifa(cliente, fabrica.getTarifa(tipo,cliente.getTarifa()));

        //Usamos un constructor provisional para crear la llamada y controlar la fecha y hora
        LocalDate fecha = LocalDate.of(2020, 4, 19);
        LocalTime hora = LocalTime.of(17,00);
        Llamada llamada = new Llamada(1, fecha, hora);
        gestion.anadirLlamada(cliente, llamada);

        // Creamos la factura y nos guardamos su importe
        gestion.emitirFactura(cliente, LocalDate.of(2020,3,1),
                LocalDate.of(2020,5,1));
        Factura factura = gestion.recuperarFactura(cod++);
        double importe = factura.getImporte();
        assertThat(importe, is((double) 5));
    }

    @Test
    public void testTarifaDomingos(){
        Gestion gestion = new Gestion();
        Cliente cliente = testSetUp.crearCliente();
        gestion.anadirCliente(cliente);
        FabricaTarifasParametrizada fabrica = new FabricaTarifasParametrizada();
        TipoTarifa tipo = TipoTarifa.DOMINGOS;
        gestion.cambiarTarifa(cliente, fabrica.getTarifa(tipo,cliente.getTarifa()));

        //Usamos un constructor provisional para crear la llamada y controlar la fecha y hora
        LocalDate fecha = LocalDate.of(2020, 4, 19);
        LocalTime hora = LocalTime.of(17,00);
        Llamada llamada = new Llamada(1, fecha, hora);
        gestion.anadirLlamada(cliente, llamada);

        // Creamos la factura y nos guardamos su importe
        gestion.emitirFactura(cliente, LocalDate.of(2020,3,1),
                LocalDate.of(2020,5,1));
        Factura factura = gestion.recuperarFactura(cod++);
        double importe = factura.getImporte();
        assertThat(importe, is((double) 0));
    }

    @Test
    public void testDistintasTarifas(){
        Gestion gestion = new Gestion();
        Cliente cliente = testSetUp.crearCliente();
        gestion.anadirCliente(cliente);
        FabricaTarifasParametrizada fabrica = new FabricaTarifasParametrizada();
        TipoTarifa tipo = TipoTarifa.DOMINGOS;
        gestion.cambiarTarifa(cliente, fabrica.getTarifa(tipo,cliente.getTarifa()));
        tipo = TipoTarifa.TARDES;
        gestion.cambiarTarifa(cliente, fabrica.getTarifa(tipo,cliente.getTarifa()));

        //Usamos un constructor provisional para crear la llamada y controlar la fecha y hora
        LocalDate fecha = LocalDate.of(2020, 4, 19);
        LocalTime hora = LocalTime.of(17,00);
        Llamada llamada = new Llamada(1, fecha, hora);
        gestion.anadirLlamada(cliente, llamada);

        fecha = LocalDate.of(2020, 4, 20);
        hora = LocalTime.of(17,00);
        llamada = new Llamada(1, fecha, hora);
        gestion.anadirLlamada(cliente, llamada);

        fecha = LocalDate.of(2020, 4, 18);
        hora = LocalTime.of(12,00);
        llamada = new Llamada(1, fecha, hora);
        gestion.anadirLlamada(cliente, llamada);

        // Creamos la factura y nos guardamos su importe
        gestion.emitirFactura(cliente, LocalDate.of(2020,3,1),
                LocalDate.of(2020,5,1));
        Factura factura = gestion.recuperarFactura(cod++);
        double importe = factura.getImporte();
        assertThat(importe, is((double) 20));




    }
}
