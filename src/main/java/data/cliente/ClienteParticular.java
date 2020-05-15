package data.cliente;

import data.cliente.datos.Direccion;

public class ClienteParticular extends Cliente {
    private String apellidos;


    public ClienteParticular(String nombre, String NIF, String correo_e, Direccion direccion, String apellidos) {
        super(nombre, NIF, correo_e, direccion);
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Cliente:" + '\n' +
                "\tnombre = " + nombre + '\n' +
                "\tapellidos = " + apellidos + '\n' +
                "\tNIF = " + NIF + '\n' +
                "\teMail = " + eMail + '\n' +
                "\tfecha = " + fecha + '\n' +
                "\ttarifa = " + tarifa + '\n' +
                "\tdireccion = " + direccion
                ;
    }
    public String getApellidos(){
        return apellidos;
    }
}
