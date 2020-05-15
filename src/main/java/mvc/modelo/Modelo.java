package mvc.modelo;

import data.Fecha;
import data.cliente.Cliente;
import data.cliente.datos.Direccion;
import gestion.fabricas.Fabrica;
import gestion.fabricas.FabricaClientes;
import gestion.*;
import mvc.vista.InformarVista;
import mvc.vista.tablas.tablaClientes.InformaVistaTablaClientes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Modelo implements ActualizaModelo, InterrogaModelo{
    Gestion gestor=new Gestion();
    InformarVista vista;

    public void setVista(InformarVista vista) {
        this.vista = vista;

    }

    public void crearCliente(String nombre,String apellidos,String nif, String email, String poblacion, String provincia, int cp){
        Fabrica cliente= new FabricaClientes();

        Direccion direccion = new Direccion(cp,provincia,poblacion);
        if(apellidos==null) gestor.anadirCliente(cliente.getClienteEmpresa(nombre,nif,email,direccion));
        else gestor.anadirCliente(cliente.getClienteParticular(nombre,nif,email,direccion,apellidos));
    }

    public void borrarCliente(String dni){
        gestor.borrarCliente(dni);
    }

    public ArrayList<Cliente> listarClientes(){
        ArrayList<Cliente> clientes=new ArrayList<>();
        clientes.addAll(gestor.listarClientes());
        return clientes;
    }

    public ArrayList<Cliente> clientesEntreFechas(LocalDate fechaInicio, LocalDate fin){
        ArrayList<Cliente> clientes=new ArrayList<>();
        clientes.addAll(gestor.getDatosEntreFechas(gestor.listarClientes(),fechaInicio,fin));
        return clientes;
    }
}
