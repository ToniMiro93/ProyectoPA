package baseDeDatos;

import java.util.Scanner;

public class Run {
    private Scanner sc=new Scanner(System.in);
    public gestionClientes gestion=new gestionClientes();

    public Run() {
        while (true) {
            int opcion = getOpcionPrincipal();
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
                    mostrarCliente();
                    break;
                case 5:
                    mostrarClientes();
                    break;
                case 6:
                    gestionLlamadas();
                    break;
            }

        }
    }
    public void gestionLlamadas(){
        while(true){
            int opcion=getOpcionLlamadas();
            switch (opcion) {
                case 1:
                    darAltaLlamada();
                    break;
                case 2:
                    borrarCliente();
                    break;
                default:
            }
        }
    }

    private int getOpcionLlamadas(){
        System.out.println("Menú de gestion de llamadas de clientes v1.0");
        System.out.println("----------------------------------------------");
        System.out.println("1)Dar de alta una llamada.");
        System.out.println("2)Borrar cliente.");
        System.out.println("3)(atras).");
        int opcion=sc.nextInt();
        while (opcion<1 || opcion>3) {
            System.out.println("Escoge una opcion correcta!.");
            opcion=getOpcionLlamadas();
        }
        return opcion;
    }

    private void anadirCliente() {
        gestion.nuevoCliente(crearCliente());
    }

    private Cliente crearCliente() {
        int opcion = getOpcionParticularEmpresa();
        Cliente nuevoCliente=null;
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
        switch (opcion){
            case 1:
                System.out.print("Apellido:");
                String apellido=sc.next();
                nuevoCliente=new ClienteParticulares(nombre,NIF,email,direccion,apellido);
                break;
            case 2:
                nuevoCliente=new ClienteEmpresas(nombre,NIF,email,direccion);
                break;
            default:
        }

        return nuevoCliente;
    }
    private int getOpcionPrincipal() {
        int opcion;
        System.out.println("Menú de gestion de clientes de telefonia v1.0");
        System.out.println("----------------------------------------------");
        System.out.println("1)Añadir cliente.");
        System.out.println("2)Borrar cliente.");
        System.out.println("3)Cambiar tarifa de cliente.");
        System.out.println("4)Mostrar cliente.");
        System.out.println("5)Listado de clientes.");
        System.out.println("6)Gestionar llamadas de un cliente.");
        System.out.println("7)Gestionar facturación de un cliente.");
        System.out.print("Elige la opcion que quieras realizar:");
        opcion=sc.nextInt();
        while (opcion<1 || opcion>7) {
            System.out.println("Escoge una opcion correcta!.");
            opcion=getOpcionParticularEmpresa();
        }
        return opcion;
    }

    private int getOpcionParticularEmpresa() {
        int opcion;
        System.out.println("Cliente particular o empresa?");
        System.out.println("1)Particular.");
        System.out.println("2)Empresa.");
        System.out.println("3)(volver)");
        System.out.print("Opción:");
        opcion=sc.nextInt();
        while (opcion<1 || opcion>3) {
            System.out.println("Escoge una opcion correcta!.");
            opcion=getOpcionParticularEmpresa();
        }
        return opcion;
    }

    private void borrarCliente(){

        System.out.println("-----------------");
        System.out.println("1)Borrar Cliente a partir de su NIF.");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion=sc.nextInt();
        switch (opcion){
            case 1:
                System.out.print("Introduce el NIF:");
                String NIF=sc.next();
                if (gestion.getClientes().containsKey(NIF)){
                    gestion.borrarCliente(gestion.getClientes().get(NIF));
                }
                break;
            default:
        }
    }
    private void cambiarTarifa(){
        System.out.println("-----------------");
        System.out.println("1)Cambiar Tarifa a partir de su NIF.");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion=sc.nextInt();
        switch (opcion){
            case 1:
                System.out.print("Introduce el NIF:");
                String NIF=sc.next();
                if (gestion.getClientes().containsKey(NIF)){
                    System.out.print("Introduce la nueva tarifa:");
                    int tarifa=sc.nextInt();
                    gestion.cambiarTarifa(gestion.getClientes().get(NIF),tarifa);
                }
                break;
            default:
        }
    }

    private void mostrarCliente(){
        System.out.println("-----------------");
        System.out.println("1)Mostrar cliente a partir de su NIF.");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion=sc.nextInt();
        switch (opcion){
            case 1:
                System.out.print("Introduce el NIF:");
                String NIF=sc.next();
                if (gestion.getClientes().containsKey(NIF)){
                    System.out.println(gestion.datosCliente(NIF).toString());
                }
                break;
            default:
        }
    }

    private void mostrarClientes(){
        System.out.println("-----------------");
        System.out.println("1)Mostrar Listado de clientes");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion=sc.nextInt();
        switch (opcion){
            case 1:
                System.out.println("NIF"+"\t"+"Nombre");
                System.out.println("---------"+ "\t" + "---------");
                for (Cliente cliente: gestion.listadoClientes()){
                    System.out.println(cliente.getNIF() + "\t" + cliente.getNombre());
                }
                break;
            default:
        }
    }

    private void darAltaLlamada(){
        System.out.println("-----------------");
        System.out.println("1)Dar de alta llamada a partir de su NIF.");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion=sc.nextInt();
        switch (opcion){
            case 1:
                System.out.print("Introduce el NIF:");
                String NIF=sc.next();
                if (gestion.getClientes().containsKey(NIF)){
                    System.out.print("Introduce el numero de destino:");
                    long numDest=sc.nextLong();
                    System.out.print("Introduce la duracion de la llamada(min):");
                    int duracion=sc.nextInt();
                    Llamada llamada=new Llamada(numDest,duracion);
                    gestion.anadirLlamada(gestion.getClientes().get(NIF),llamada);
                }
                break;
            default:
        }
    }
}
