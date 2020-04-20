import data.cliente.Cliente;
import data.cliente.ClienteParticular;
import data.cliente.datos.Direccion;
import es.uji.www.GeneradorDatosINE;
import gestion.Gestion;
import gestion.fabricas.FabricaClientes;

public class testSetUp {

    //Generación de una muestra de 20 cliente aleatoria
    public static Gestion crearDatosMuestra(){
        Gestion gestion = new Gestion();
        for(int i = 0; i < 20; i++){
            gestion.anadirCliente(crearCliente());
        }
        return gestion;
    }

    public static Cliente crearCliente(){
        GeneradorDatosINE generador=new GeneradorDatosINE();
        FabricaClientes fabrica = new FabricaClientes();

        String nombre=generador.getNombre();
        String NIF=generador.getNIF();
        String correo=nombre+"@gmail.com";
        String provincia=generador.getProvincia();
        String poblacion=generador.getPoblacion(provincia);
        int cp=12000;
        Direccion direccion=new Direccion(cp,provincia,poblacion);

//        Cliente cliente = fabrica.getClienteParticular(nombre, generador.getApellido(), NIF, correo, direccion);
//        return cliente;
        return new ClienteParticular(nombre,NIF,correo,direccion,generador.getApellido());
    }
}
