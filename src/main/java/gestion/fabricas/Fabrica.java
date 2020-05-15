package gestion.fabricas;

import data.cliente.Cliente;
import data.cliente.datos.Direccion;

public interface Fabrica {
    public Cliente getClienteParticular(String nombre, String NIF, String correo_e, Direccion direccion, String apellidos);
    public Cliente getClienteEmpresa(String nombre, String NIF, String correo_e, Direccion direccion);
}
