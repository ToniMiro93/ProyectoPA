package data.clientes;

import data.clientes.datos.Direccion;

public class ClienteEmpresa extends Cliente {

    public ClienteEmpresa(String nombre, String NIF, String correo_e, Direccion direccion) {
        super(nombre, NIF, correo_e, direccion);
    }
}
