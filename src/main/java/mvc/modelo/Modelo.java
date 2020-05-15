package mvc.modelo;

import data.cliente.Cliente;
import data.cliente.datos.Direccion;
import gestion.fabricas.Fabrica;
import gestion.fabricas.FabricaClientes;
import gestion.*;
import mvc.modelo.tablas.ModeloTablaClientes;
import mvc.vista.InformarVista;

import javax.swing.table.AbstractTableModel;
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

    public AbstractTableModel listarClientes(){
        ArrayList<Cliente> clientes=new ArrayList<>();
        clientes.addAll(gestor.listarClientes());
        return new ModeloTablaClientes(clientes);
    }


    public ArrayList<Cliente> clientesEntreFechas(LocalDate fechaInicio, LocalDate fin){
        ArrayList<Cliente> clientes=new ArrayList<>();
        clientes.addAll(gestor.getDatosEntreFechas(gestor.listarClientes(),fechaInicio,fin));
        return clientes;
    }

    @Override
    public AbstractTableModel recuperarCliente(String nif) {
        ArrayList<Cliente> cliente = new ArrayList<>();
        cliente.add(gestor.recuperarCliente(nif));
        return new ModeloTablaClientes(cliente);
    }
}
