import baseDeDatos.clientes.Cliente;
import baseDeDatos.llamadas.Llamada;
import gestion.Gestion;
import org.junit.Test;

import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestLlamadas {

    @Test
    public void testAñadirLlamada(){
        Gestion gestion = new Gestion();
        Cliente clientePrueba = testSetUp.crearCliente();
        gestion.anadirCliente(clientePrueba);
        int llamadasAntes = gestion.listarLlamadas(clientePrueba).size();
        gestion.anadirLlamada(clientePrueba, new Llamada(111111111, 10));
        int llamadasDespues = gestion.listarLlamadas(clientePrueba).size();
        assertThat(llamadasDespues, is(llamadasAntes + 1));
    }

    @Test
    public void testListarLlamadas(){
        Gestion gestion = new Gestion();
        HashSet<Llamada> setPrueba = new HashSet<>();
        Cliente cliente = testSetUp.crearCliente();
        gestion.anadirCliente(cliente);
        for (int i = 0; i < 6; i++){
            Llamada llamada = new Llamada(644111111, 3);
            gestion.anadirLlamada(cliente, llamada);
            setPrueba.add(llamada);
        }
        int tamanoAntes = setPrueba.size();
        setPrueba.retainAll(gestion.listarLlamadas(cliente));
        setPrueba.addAll(gestion.listarLlamadas(cliente));
        int tamanoDespues = setPrueba.size();
        assertThat(tamanoAntes, is(tamanoDespues));
    }
}
