package baseDeDatos;

import java.util.Scanner;

public class menu {
    private Scanner sc=new Scanner(System.in);
    public gestionClientes gestion=new gestionClientes();

    public void menu(){
        while(true){
            int opcion = getOpcionPrincipal();
            switch (opcion){
                case 1:
                    opcion = getOpcionParticularEmpresa();
                    Cliente nuevoCliente=null;
                    switch (opcion){
                        case 1:
                            nuevoCliente=new ClienteParticulares();
                            break;
                        case 2:
                            nuevoCliente=new ClienteEmpresas();
                            break;
                        case 3:
                    }
                    if (nuevoCliente==null)
                        break;
                    else if (nuevoCliente instanceof ClienteEmpresas)
                    System.out.println("Introduce los datos requeridos.");
                    System.out.print("Nombre:");
                    gestion.nuevoCliente();
            }
            while (true) {
            System.out.println(""
            System.out.print("Elige la opcion que quieras realizar:");
            switch (opcion){
                case 1:

            }

        }
    }
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
