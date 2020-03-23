
import data.cliente.Cliente;
import gestion.Gestion;
import gestion.excepciones.ClienteNotFoundException;
import gestion.excepciones.ElementosNoEncontradosException;
import gestion.excepciones.FacturaNotFoundException;
import gestion.excepciones.ListaDeClientesVaciaException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;
import java.util.HashSet;

public class TestExcepciones {

    @Test
    public void testClienteNotFoundException() {
        Gestion gestion = new Gestion();
        assertThrows(ClienteNotFoundException.class, () -> gestion.recuperarCliente("1111111T"));
    }

    @Test
    public void testFacturaNotFoundException() {
        Gestion gestion = new Gestion();
        assertThrows(FacturaNotFoundException.class, () -> gestion.recuperarFactura(11));
    }

    @Test
    public void testElementosNoEncontradosException() {
        Gestion gestion = testSetUp.crearDatosMuestra();
        assertThrows(ElementosNoEncontradosException.class, () -> gestion.getDatosEntreFechas(
                gestion.listarClientes(), LocalDate.of(2000,1,1),
                LocalDate.of(2001,1,1)));
    }

    @Test
    public void testListaDeClientesVaciaException() {
        Gestion gestion = new Gestion();
        assertThrows(ListaDeClientesVaciaException.class, () -> gestion.listarClientes());
    }
}
