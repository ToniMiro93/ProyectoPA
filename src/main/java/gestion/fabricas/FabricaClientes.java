package gestion.fabricas;

import data.cliente.Cliente;
import data.cliente.ClienteEmpresa;
import data.cliente.ClienteParticular;
import data.cliente.datos.Direccion;

public class FabricaClientes {

    public Cliente getClienteParticular(String nombre, String apellidos, String NIF, String correo_e, Direccion direccion){
        return new ClienteParticular(nombre, NIF, correo_e, direccion, apellidos);
    }

    public Cliente getClienteEmpresa(String nombre, String NIF, String correo_e, Direccion direccion){
        return new ClienteEmpresa(nombre, NIF, correo_e, direccion);
    }
}
