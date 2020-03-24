package data.cliente;

import data.cliente.datos.Direccion;

public class ClienteParticular extends Cliente {
    private String apellidos;


    public ClienteParticular(String nombre, String NIF, String correo_e, Direccion direccion, String apellidos) {
        super(nombre, NIF, correo_e, direccion);
        this.apellidos = apellidos;
    }

    private String mostrarNombre(){
        return "\tnombre = " + super.getNombre() + '\n' +
               "\tapellidos = " + apellidos + '\n';
    }
}
