package baseDeDatos.clientes;

import baseDeDatos.clientes.datos.Direccion;

public class ClienteEmpresas extends Cliente {

    public ClienteEmpresas(String nombre, String NIF, String correo_e, Direccion direccion) {
        super(nombre, NIF, correo_e, direccion);
    }
}
