package mvc.modelo;

import data.cliente.Cliente;
import data.cliente.datos.Direccion;
import gestion.fabricas.Fabrica;
import gestion.fabricas.FabricaClientes;
import gestion.*;
import mvc.modelo.tablas.InterrogaTablas;
import mvc.vista.InformarVista;

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

    public InterrogaTablas consultaTabla(){
        return null;
    }

    public ArrayList<Cliente> clientesEntreFechas(LocalDate fechaInicio, LocalDate fin){
        ArrayList<Cliente> clientes=new ArrayList<>();
        clientes.addAll(gestor.getDatosEntreFechas(gestor.listarClientes(),fechaInicio,fin));
        return clientes;
    }

    @Override
    public Cliente recuperarCliente(String nif) {
        return gestor.recuperarCliente(nif);
    }
}
