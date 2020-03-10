import data.clientes.Cliente;
import data.clientes.ClienteParticular;
import data.clientes.datos.Direccion;
import es.uji.www.GeneradorDatosINE;
import gestion.Gestion;

public class testSetUp {

    //Generación de una muestra de 20 clientes aleatoria
    static Gestion crearDatosMuestra(){
        Gestion gestion = new Gestion();
        for(int i = 0; i < 20; i++){
            gestion.anadirCliente(crearCliente());
        }
        return gestion;
    }

    static Cliente crearCliente(){
        GeneradorDatosINE generador=new GeneradorDatosINE();

        String nombre=generador.getNombre();
        String NIF=generador.getNIF();
        String correo=nombre+"@gmail.com";
        String provincia=generador.getProvincia();
        String poblacion=generador.getPoblacion(provincia);
        int cp=12000;
        Direccion direccion=new Direccion(cp,provincia,poblacion);

        return new ClienteParticular(nombre,NIF,correo,direccion,generador.getApellido());
    }
}
