import baseDeDatos.clientes.Cliente;
import baseDeDatos.facturas.Factura;
import gestion.Gestion;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestFacturas {
//
//    @Test
//    public void testAnadirFactura() {
//        Gestion gestion = testSetUp.crearDatosMuestra();
//        Cliente cliente = testSetUp.crearCliente();
//        gestion.anadirCliente(cliente);
//        Factura factura = gestion.recuperarFactura(1);
//
//        assertThat(factura, null);
//        gestion.emitirFactura(cliente, LocalDate.of(23,8,2000), LocalDate.of(24,8,2000));
//        factura = gestion.recuperarFactura(1);
//        //assertThat(factura, is());
//    }
}
