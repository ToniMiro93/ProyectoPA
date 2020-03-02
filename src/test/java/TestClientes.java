import baseDeDatos.clientes.Cliente;
import baseDeDatos.clientes.ClienteParticulares;
import baseDeDatos.clientes.datos.Direccion;
import baseDeDatos.llamadas.Llamada;
import es.uji.www.GeneradorDatosINE;
import gestion.Gestion;
import gestion.GestionClientes;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashSet;
import java.util.Optional;


public class TestClientes {
//    private static GeneradorDatosINE generador;


    @Test
    public void testNuevoCliente() {
        //Creo la base de datos
        Gestion gestion = crearDatosMuestra();
        int clientesAntes = gestion.listarClientes().size();
        gestion.anadirCliente(crearCliente());
        int clientesDespues = gestion.listarClientes().size();
        assertThat(clientesDespues, is(clientesAntes + 1));
    }

    @Test
    public void testBorrarClienteByNIF(){
        Gestion gestion = crearDatosMuestra();
        Cliente cliente = crearCliente();
        gestion.anadirCliente(cliente);
        int clientesAntes = gestion.listarClientes().size();
        gestion.borrarCliente(cliente.getNIF());
        int clientesDespues = gestion.listarClientes().size();
        assertThat(clientesDespues, is(clientesAntes - 1));
    }

    @Test
    public void testRecuperarClienteByNIF(){
        Gestion gestion = crearDatosMuestra();
        Cliente nuevoCliente = crearCliente();
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
            cliente = crearCliente();
            gestion.anadirCliente(cliente);
            setPrueba.add(cliente);
        }
        int tamanoAntes = setPrueba.size();
        setPrueba.retainAll(gestion.listarClientes());
        setPrueba.addAll(gestion.listarClientes());
        int tamanoDespues = setPrueba.size();
        assertThat(tamanoAntes, is(tamanoDespues));
    }

//    @Test
//    public void testAñadirLlamada(){
//        GestionClientes gestion = new GestionClientes();
//        Cliente clientePrueba = crearCliente();
//        gestion.nuevoCliente(clientePrueba);
//        int llamadasAntes = gestion.listadoLlamadas(clientePrueba).size();
//        gestion.anadirLlamada(clientePrueba, new Llamada(111111111, 10));
//        int llamadasDespues = gestion.listadoLlamadas(clientePrueba).size();
//        assertThat(llamadasDespues, is(llamadasAntes + 1));
//    }

    //Generación de una muestra de 20 clientes aleatoria
    private static Gestion crearDatosMuestra(){
        Gestion gestion = new Gestion();
        for(int i = 0; i < 20; i++){
            gestion.anadirCliente(crearCliente());
        }
        return gestion;
    }

    //Generación de un cliente aleatorio
    private static Cliente crearCliente(){
        GeneradorDatosINE generador=new GeneradorDatosINE();

        //Generacion de datos
        String nombre=generador.getNombre();
        String NIF=generador.getNIF();
        String correo=nombre+"@gmail.com";
        String provincia=generador.getProvincia();
        String poblacion=generador.getPoblacion(provincia);
        int cp=12000;
        Direccion direccion=new Direccion(cp,provincia,poblacion);

        //Creación del cliente
        return new ClienteParticulares(nombre,NIF,correo,direccion,generador.getApellido());
    }

//    private static Cliente seleccionarCualquierCliente(Gestion gestion){
//        Optional<Cliente> any = gestion.listarClientes().stream().findAny();
//        return any.get();
//    }

}