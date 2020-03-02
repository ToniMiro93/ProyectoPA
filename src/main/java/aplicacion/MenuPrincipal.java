package aplicacion;

import baseDeDatos.clientes.Cliente;
import baseDeDatos.clientes.ClienteEmpresas;
import baseDeDatos.clientes.ClienteParticulares;
import baseDeDatos.clientes.datos.Direccion;
import gestion.Gestion;

import java.util.Scanner;

public class MenuPrincipal {
    protected Scanner sc;
    public Gestion gestion;

    public MenuPrincipal(){
        sc=new Scanner(System.in);
        gestion=new Gestion();
    }

    public Gestion getGestion() {
        return gestion;
    }

    public void start(){
        while (true) {
            int opcion = getOpcionPrincipal();
            switch (opcion) {
                case 1:
                    //anadirCliente();
                    break;
                case 2:
                    //borrarCliente();
                    break;
                case 3:
                    //cambiarTarifa();
                    break;
                case 4:
                    //mostrarCliente();
                    break;
                case 5:
                    //mostrarClientes();
                    break;
                case 6:
                    gestionLlamadas();
                    break;
                case 7:
                    gestionFacturas();
                    break;
                case 8:
                    return;
                default:
            }

        }
    }
    public void gestionLlamadas(){
        while(true){
            int opcion=getOpcionLlamadas();
            switch (opcion) {
                case 1:
                    //darAltaLlamada();
                    break;
                case 2:
                    //recuperarFacturaCodigo();
                    break;
                case 3:
                    return;
                default:
            }
        }
    }

    public void gestionFacturas(){
        while(true){
            int opcion=getOpcionFacturas();
            switch (opcion) {
                case 1:
                    //emitirFactura();
                    break;
                case 2:
                    recuperarFacturaCodigo();
                    break;
                case 3:
                    recuperarFacturasNIF();
                    break;
                case 4:
                    return;
                default:
            }
        }
    }

    private int getOpcionFacturas(){
        System.out.println("Menú de gestion de facturas v1.0");
        System.out.println("----------------------------------------------");
        System.out.println("1)Emitir factura");
        System.out.println("2)Mostrar factura");
        System.out.println("3)Mostrar facturas de un cliente.");
        System.out.println("4)(atras).");
        int opcion=sc.nextInt();
        while (opcion<1 || opcion>4) {
            System.out.println("Escoge una opcion correcta!.");
            opcion=getOpcionLlamadas();
        }
        return opcion;
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
        System.out.println("8)Salir.");
        System.out.print("Elige la opcion que quieras realizar:");
        opcion=sc.nextInt();
        while (opcion<1 || opcion>7) {
            System.out.println("Escoge una opcion correcta!.");
            //opcion=getOpcionParticularEmpresa();
        }
        return opcion;
    }











    private void recuperarFacturaCodigo() {
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
    }

    private void recuperarFacturasNIF() {
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
    }

}
