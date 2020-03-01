import baseDeDatos.Cliente;
import baseDeDatos.ClienteParticulares;
import baseDeDatos.Direccion;
import baseDeDatos.gestionClientes;
import es.uji.www.GeneradorDatosINE;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.time.LocalDate;
import java.util.HashSet;
import baseDeDatos.*;


public class TestClientes {
    @Test
    public void testNuevoCliente() {
        gestionClientes gestion=new gestionClientes();
        HashSet<Cliente> clientes=new HashSet<>();
        for(int i = 0; i<20; i++){
            GeneradorDatosINE generador=new GeneradorDatosINE();
            String nombre=generador.getNombre();
            String NIF=generador.getNIF();
            String correo=nombre+"@gmail.com";
            String provincia=generador.getProvincia();
            String poblacion=generador.getPoblacion(provincia);
            int cp=1;
            Direccion direccion=new Direccion(cp,provincia,poblacion);
            LocalDate fecha=LocalDate.now();
            Cliente cliente=new ClienteParticulares(nombre,NIF,correo,fecha,direccion,generador.getApellido());
            clientes.add(cliente);
            gestion.nuevoCliente(cliente);
        }
        assertThat(true,is(clientes.containsAll(gestion.listadoClientes())));
    }
}
