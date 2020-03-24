import data.cliente.Cliente;
import gestion.Gestion;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashSet;


public class TestClientes {
//    private static GeneradorDatosINE generador;


    @Test
    public void testNuevoCliente() {
        Gestion gestion = testSetUp.crearDatosMuestra();
        int clientesAntes = gestion.listarClientes().size();
        gestion.anadirCliente(testSetUp.crearCliente());
        int clientesDespues = gestion.listarClientes().size();
        assertThat(clientesDespues, is(clientesAntes + 1));
    }

    @Test
    public void testBorrarClienteByNIF(){
        Gestion gestion = testSetUp.crearDatosMuestra();
        Cliente cliente = testSetUp.crearCliente();
        gestion.anadirCliente(cliente);
        int clientesAntes = gestion.listarClientes().size();
        gestion.borrarCliente(cliente.getNIF());
        int clientesDespues = gestion.listarClientes().size();
        assertThat(clientesDespues, is(clientesAntes - 1));
    }

    @Test
    public void testRecuperarClienteByNIF(){
        Gestion gestion = testSetUp.crearDatosMuestra();
        Cliente nuevoCliente = testSetUp.crearCliente();
        gestion.anadirCliente(nuevoCliente);
        Cliente clienteRecuperado = gestion.recuperarCliente(nuevoCliente.getNIF());
        boolean sonIguales = clienteRecuperado.equals(nuevoCliente);
        assertThat(true, is(sonIguales));
    }

    @Test
    public void testListadoClientes(){
        Gestion gestion = new Gestion();
        HashSet<Cliente> setPrueba = new HashSet<>();
        Cliente cliente;
        for (int i = 0; i < 6; i++){
            cliente = testSetUp.crearCliente();
            gestion.anadirCliente(cliente);
            setPrueba.add(cliente);
        }
        int tamanoAntes = setPrueba.size();
        setPrueba.retainAll(gestion.listarClientes());
        setPrueba.addAll(gestion.listarClientes());
        int tamanoDespues = setPrueba.size();
        assertThat(tamanoAntes, is(tamanoDespues));
    }
}