package data.clientes;

import data.clientes.datos.Direccion;

public class ClienteParticular extends Cliente {
    private String apellido1;


    public ClienteParticular(String nombre, String NIF, String correo_e, Direccion direccion, String apellido1) {
        super(nombre, NIF, correo_e, direccion);
        this.apellido1=apellido1;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "apellido1='" + apellido1;
    }
}
