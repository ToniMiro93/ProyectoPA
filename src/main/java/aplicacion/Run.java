package aplicacion;

import baseDeDatos.facturas.Factura;
import baseDeDatos.llamadas.Llamada;
import baseDeDatos.clientes.Cliente;
import baseDeDatos.clientes.ClienteEmpresas;
import baseDeDatos.clientes.ClienteParticulares;
import baseDeDatos.clientes.datos.Direccion;
import gestion.GestionClientes;

import java.time.LocalDate;
import java.util.Scanner;

public class Run {
//    private Scanner sc=new Scanner(System.in);
//    public GestionClientes gestion=new GestionClientes();
//
//    public Run() {
//        while (true) {
//            int opcion = getOpcionPrincipal();
//            switch (opcion) {
//                case 1:
//                    anadirCliente();
//                    break;
//                case 2:
//                    borrarCliente();
//                    break;
//                case 3:
//                    cambiarTarifa();
//                    break;
//                case 4:
//                    mostrarCliente();
//                    break;
//                case 5:
//                    mostrarClientes();
//                    break;
//                case 6:
//                    gestionLlamadas();
//                    break;
//                case 7:
//                    gestionFacturas();
//                    break;
//                case 8:
//                    return;
//                default:
//            }
//
//        }
//    }
//    public void gestionLlamadas(){
//        while(true){
//            int opcion=getOpcionLlamadas();
//            switch (opcion) {
//                case 1:
//                    darAltaLlamada();
//                    break;
//                case 2:
//                    recuperarFacturaCodigo();
//                    break;
//                case 3:
//                    return;
//                default:
//            }
//        }
//    }
//
//    public void gestionFacturas(){
//        while(true){
//            int opcion=getOpcionFacturas();
//            switch (opcion) {
//                case 1:
//                    emitirFactura();
//                    break;
//                case 2:
//                    recuperarFacturaCodigo();
//                    break;
//                case 3:
//                    recuperarFacturasNIF();
//                    break;
//                case 4:
//                    return;
//                default:
//            }
//        }
//    }
//
//    private int getOpcionFacturas(){
//        System.out.println("Menú de gestion de facturas v1.0");
//        System.out.println("----------------------------------------------");
//        System.out.println("1)Emitir factura");
//        System.out.println("2)Mostrar factura");
//        System.out.println("3)Mostrar facturas de un cliente.");
//        System.out.println("4)(atras).");
//        int opcion=sc.nextInt();
//        while (opcion<1 || opcion>4) {
//            System.out.println("Escoge una opcion correcta!.");
//            opcion=getOpcionLlamadas();
//        }
//        return opcion;
//    }
//    private int getOpcionLlamadas(){
//        System.out.println("Menú de gestion de llamadas de clientes v1.0");
//        System.out.println("----------------------------------------------");
//        System.out.println("1)Dar de alta una llamada.");
//        System.out.println("2)Borrar cliente.");
//        System.out.println("3)(atras).");
//        int opcion=sc.nextInt();
//        while (opcion<1 || opcion>3) {
//            System.out.println("Escoge una opcion correcta!.");
//            opcion=getOpcionLlamadas();
//        }
//        return opcion;
//    }
//
//    private void anadirCliente() {
//        gestion.nuevoCliente(crearCliente());
//    }
//
//    private Cliente crearCliente() {
//        int opcion = getOpcionParticularEmpresa();
//        Cliente nuevoCliente=null;
//        System.out.println("Introduce los datos requeridos.");
//        System.out.println("-------------------------------");
//        System.out.print("NIF:");
//        String NIF = sc.next();
//
//        System.out.print("E-mail:");
//        String email = sc.next();
//
//        System.out.println("Introduce la direccion:");
//        System.out.print("Provincia:");
//        String provincia = sc.next();
//
//        System.out.print("Poblacion:");
//        String poblacion = sc.next();
//
//        System.out.print("CodigoPostal:");
//        int CP = sc.nextInt();
//
//        Direccion direccion = new Direccion(CP, provincia, poblacion);
//
//        System.out.print("Nombre:");
//        String nombre = sc.next();
//        switch (opcion){
//            case 1:
//                System.out.print("Apellido:");
//                String apellido=sc.next();
//                nuevoCliente=new ClienteParticulares(nombre,NIF,email,direccion,apellido);
//                break;
//            case 2:
//                nuevoCliente=new ClienteEmpresas(nombre,NIF,email,direccion);
//                break;
//            default:
//        }
//
//        return nuevoCliente;
//    }
//    private int getOpcionPrincipal() {
//        int opcion;
//        System.out.println("Menú de gestion de clientes de telefonia v1.0");
//        System.out.println("----------------------------------------------");
//        System.out.println("1)Añadir cliente.");
//        System.out.println("2)Borrar cliente.");
//        System.out.println("3)Cambiar tarifa de cliente.");
//        System.out.println("4)Mostrar cliente.");
//        System.out.println("5)Listado de clientes.");
//        System.out.println("6)Gestionar llamadas de un cliente.");
//        System.out.println("7)Gestionar facturación de un cliente.");
//        System.out.println("8)Salir.");
//        System.out.print("Elige la opcion que quieras realizar:");
//        opcion=sc.nextInt();
//        while (opcion<1 || opcion>7) {
//            System.out.println("Escoge una opcion correcta!.");
//            opcion=getOpcionParticularEmpresa();
//        }
//        return opcion;
//    }
//
//    private int getOpcionParticularEmpresa() {
//        int opcion;
//        System.out.println("Cliente particular o empresa?");
//        System.out.println("1)Particular.");
//        System.out.println("2)Empresa.");
//        System.out.println("3)(volver)");
//        System.out.print("Opción:");
//        opcion=sc.nextInt();
//        while (opcion<1 || opcion>3) {
//            System.out.println("Escoge una opcion correcta!.");
//            opcion=getOpcionParticularEmpresa();
//        }
//        return opcion;
//    }
//
//    private void borrarCliente(){
//
//        System.out.println("-----------------");
//        System.out.println("1)Borrar Cliente a partir de su NIF.");
//        System.out.println("2)(atras)");
//        System.out.println("Escoge una opcion:");
//        int opcion=sc.nextInt();
//        switch (opcion){
//            case 1:
//                System.out.print("Introduce el NIF:");
//                String NIF=sc.next();
//                if (gestion.getClientes().containsKey(NIF)){
//                    gestion.borrarCliente(gestion.getClientes().get(NIF));
//                }
//                break;
//            default:
//        }
//    }
//    private void cambiarTarifa(){
//        System.out.println("-----------------");
//        System.out.println("1)Cambiar Tarifa a partir de su NIF.");
//        System.out.println("2)(atras)");
//        System.out.println("Escoge una opcion:");
//        int opcion=sc.nextInt();
//        switch (opcion){
//            case 1:
//                System.out.print("Introduce el NIF:");
//                String NIF=sc.next();
//                if (gestion.getClientes().containsKey(NIF)){
//                    System.out.print("Introduce la nueva tarifa:");
//                    int tarifa=sc.nextInt();
//                    gestion.cambiarTarifa(gestion.getClientes().get(NIF),tarifa);
//                }
//                break;
//            default:
//        }
//    }
//
//    private void mostrarCliente(){
//        System.out.println("-----------------");
//        System.out.println("1)Mostrar cliente a partir de su NIF.");
//        System.out.println("2)(atras)");
//        System.out.println("Escoge una opcion:");
//        int opcion=sc.nextInt();
//        switch (opcion){
//            case 1:
//                System.out.print("Introduce el NIF:");
//                String NIF=sc.next();
//                if (gestion.getClientes().containsKey(NIF)){
//                    System.out.println(gestion.datosCliente(NIF).toString());
//                }
//                break;
//            default:
//        }
//    }
//
//    private void mostrarClientes(){
//        System.out.println("-----------------");
//        System.out.println("1)Mostrar Listado de clientes");
//        System.out.println("2)(atras)");
//        System.out.println("Escoge una opcion:");
//        int opcion=sc.nextInt();
//        switch (opcion){
//            case 1:
//                System.out.println("NIF"+"\t\t"+"Nombre");
//                System.out.println("---------"+ "\t" + "---------");
//                for (Cliente cliente: gestion.listadoClientes()){
//                    System.out.println(cliente.getNIF() + "\t" + cliente.getNombre());
//                }
//                break;
//            default:
//        }
//    }
//
//    private void darAltaLlamada(){
//        System.out.println("-----------------");
//        System.out.println("1)Dar de alta llamada a partir de su NIF.");
//        System.out.println("2)(atras)");
//        System.out.println("Escoge una opcion:");
//        int opcion=sc.nextInt();
//        switch (opcion){
//            case 1:
//                System.out.print("Introduce el NIF:");
//                String NIF=sc.next();
//                if (gestion.getClientes().containsKey(NIF)){
//                    System.out.print("Introduce el numero de destino:");
//                    long numDest=sc.nextLong();
//                    System.out.print("Introduce la duracion de la llamada(min):");
//                    int duracion=sc.nextInt();
//                    Llamada llamada=new Llamada(numDest,duracion);
//                    gestion.anadirLlamada(gestion.getClientes().get(NIF),llamada);
//                }
//                break;
//            default:
//        }
//    }
//
//    private void listarLLamadas() {
//        System.out.println("-----------------");
//        System.out.println("1)Mostrar Listado de llamadas de un cliente");
//        System.out.println("2)(atras)");
//        System.out.println("Escoge una opcion:");
//        int opcion = sc.nextInt();
//        switch (opcion) {
//            case 1:
//                System.out.print("Introduce el NIF:");
//                String NIF = sc.next();
//                if (gestion.getClientes().containsKey(NIF)) {
//                    for (Llamada llamada : gestion.listadoLlamadas(gestion.getClientes().get(NIF)))
//                        System.out.println(llamada.toString());
//
//                }
//            default:
//        }
//    }
//
//    private void emitirFactura() {
//        System.out.println("-----------------");
//        System.out.println("1)Emitir factura de un cliente a partir de su NIF");
//        System.out.println("2)(atras)");
//        System.out.println("Escoge una opcion:");
//        int opcion = sc.nextInt();
//        switch (opcion) {
//            case 1:
//                System.out.print("Introduce el NIF:");
//                String NIF = sc.next();
//                if (gestion.getClientes().containsKey(NIF)) {
//                    System.out.print("Introduce fecha de inicio:");
//                    System.out.print("Dia:");
//                    int dia=sc.nextInt();
//                    System.out.print("Mes:");
//                    int mes=sc.nextInt();
//                    System.out.print("Año:");
//                    int ano=sc.nextInt();
//                    LocalDate fechaInicio=LocalDate.of(ano,mes,dia);
//                    System.out.print("Introduce fecha fin:");
//                    System.out.print("Dia:");
//                    dia=sc.nextInt();
//                    System.out.print("Mes:");
//                    mes=sc.nextInt();
//                    System.out.print("Año:");
//                    ano=sc.nextInt();
//                    LocalDate fechaFin=LocalDate.of(ano,mes,dia);
//                    gestion.emitirFactura(gestion.getClientes().get(NIF),fechaInicio,fechaFin);
//                }
//            default:
//        }
//    }
//
//    private void recuperarFacturaCodigo() {
//        System.out.println("-----------------");
//        System.out.println("1)Mostrar factura a partir de su codigo");
//        System.out.println("2)(atras)");
//        System.out.println("Escoge una opcion:");
//        int opcion = sc.nextInt();
//        switch (opcion) {
//            case 1:
//                System.out.print("Introduce codigo");
//                int cod = sc.nextInt();
//                if (gestion.getCodFacturas().containsKey(cod)) {
//                    System.out.println(gestion.recuperarFactura(cod).toString());
//                }
//
//        }
//    }
//
//    private void recuperarFacturasNIF() {
//        System.out.println("-----------------");
//        System.out.println("1)Mostrar facturas de un cliente");
//        System.out.println("2)(atras)");
//        System.out.println("Escoge una opcion:");
//        int opcion = sc.nextInt();
//        switch (opcion) {
//            case 1:System.out.print("Introduce el NIF:");
//                String NIF = sc.next();
//                if (gestion.getClientes().containsKey(NIF)) {
//                    System.out.println("Cod. Factura" + "\t" + "Importe");
//                    System.out.println("------------" + "\t" + "---------");
//                    for (Factura factura : gestion.recuperarFacturas(gestion.getClientes().get(NIF))) {
//                        System.out.println(factura.getCodigo() + "\t\t" + factura.getImporte());
//                    }
//                }
//                break;
//            default:
//        }
//    }

}
