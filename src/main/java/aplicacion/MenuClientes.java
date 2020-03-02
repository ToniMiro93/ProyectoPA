package aplicacion;

import baseDeDatos.clientes.Cliente;
import baseDeDatos.clientes.ClienteEmpresas;
import baseDeDatos.clientes.ClienteParticulares;
import baseDeDatos.clientes.datos.Direccion;
import baseDeDatos.clientes.datos.Tarifa;
import gestion.Gestion;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuClientes implements Menu{

    public Scanner sc = new Scanner(System.in);
    private Gestion gestion;

    public MenuClientes(Gestion gestion) {
        this.gestion = gestion;
    }

    public void start(){
        while (true) {
            mostrarOpciones();
            int opcion = getOpcion(6);
            switch (opcion) {
                case 1:
                    anadirCliente();
                    break;
                case 2:
                    borrarCliente();
                    break;
                case 3:
                    cambiarTarifa();
                    break;
                case 4:
                    recuperarCliente();
                    break;
                case 5:
                    listarClientes();
                    break;
                case 6:
                    return;
            }
        }
    }

    @Override
    public int getOpcion(int i) {
        int opcion;
        opcion=sc.nextInt();
        while (opcion<1 || opcion>i) {
            System.out.println("Escoge una opcion correcta!");
            opcion=getOpcion(i);
        }
        return opcion;
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Menú de gestion de clientes de telefonia v1.0");
        System.out.println("----------------------------------------------");
        System.out.println("1)Añadir cliente.");
        System.out.println("2)Borrar cliente.");
        System.out.println("3)Cambiar tarifa de cliente.");
        System.out.println("4)Recuperar cliente.");
        System.out.println("5)Listado de clientes.");
        System.out.println("6)Salir del menu de clientes");
    }
    private void anadirCliente() {
        gestion.anadirCliente(crearCliente());
    }

    private Cliente crearCliente() {
        Cliente nuevoCliente;
        System.out.println("El cliente es particular o empresa? (1/2)");
        int tipo = getOpcion(2);
        System.out.println("Introduce los datos requeridos.");
        System.out.println("-------------------------------");
        System.out.print("NIF:");
        String NIF = sc.next();

        System.out.print("E-mail:");
        String email = sc.next();

        System.out.println("Introduce la direccion:");
        System.out.print("Provincia:");
        String provincia = sc.next();

        System.out.print("Poblacion:");
        String poblacion = sc.next();

        System.out.print("CodigoPostal:");
        int CP = sc.nextInt();

        Direccion direccion = new Direccion(CP, provincia, poblacion);

        System.out.print("Nombre:");
        String nombre = sc.next();
        nuevoCliente = getTipoCliente(tipo, NIF, email, direccion, nombre);
        return nuevoCliente;
    }

    private Cliente getTipoCliente(int tipo, String NIF, String email, Direccion direccion, String nombre) {
        Cliente nuevoCliente = null;
        switch (tipo){
            case 1:
                System.out.print("Apellido:");
                String apellido=sc.next();
                nuevoCliente=new ClienteParticulares(nombre,NIF,email,direccion,apellido);
                break;
            case 2:
                nuevoCliente=new ClienteEmpresas(nombre,NIF,email,direccion);
                break;
        }
        return nuevoCliente;
    }

    private void borrarCliente(){

        System.out.println("-----------------");
        System.out.println("1)Borrar Cliente a partir de su NIF.");
        System.out.println("2)(atras)");
        System.out.print("Escoge una opcion:");
        int opcion = getOpcion(2);
        switch (opcion){
            case 1:
                System.out.print("Introduce el NIF:");
                String NIF=sc.next();
                gestion.borrarCliente(NIF);
                break;
            case 2:
                return;
        }
    }

    private void cambiarTarifa(){
        System.out.println("-----------------");
        System.out.println("1)Cambiar Tarifa a partir de su NIF.");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion = getOpcion(2);
        switch (opcion){
            case 1:
                System.out.print("Introduce el NIF:");
                String NIF=sc.next();
                Cliente cliente = gestion.recuperarCliente(NIF);
                System.out.print("Introduce la nueva tarifa:");
                int tarifa=sc.nextInt();
                gestion.cambiarTarifa(cliente,new Tarifa(tarifa));
                break;
            case 2:
                return;
        }
    }

    private void recuperarCliente(){
        System.out.println("-----------------");
        System.out.println("1)Recuperar cliente a partir de su NIF.");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion = getOpcion(2);
        switch (opcion){
            case 1:
                System.out.print("Introduce el NIF:");
                String NIF=sc.next();
                Cliente cliente = gestion.recuperarCliente(NIF);
                System.out.println(cliente);
                break;
            case 2:
                return;
        }
    }

    private void listarClientes(){
        System.out.println("-----------------");
        System.out.println("1)Mostrar Listado de clientes");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion = getOpcion(2);
        switch (opcion){
            case 1:
                System.out.println("NIF"+"\t\t"+"Nombre");
                System.out.println("---------"+ "\t" + "---------");
                for (Cliente cliente: gestion.listarClientes()){
                    System.out.println(cliente.getNIF() + "\t" + cliente.getNombre());
                }
                break;
            case 2:
                return;
        }
    }




}
