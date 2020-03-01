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
                    anadirCliente();
                    break;
                case 2:
                    borrarCliente();

            }


    }
}

    private void anadirCliente() {
        int opcion;
        opcion = getOpcionParticularEmpresa();
        Cliente nuevoCliente=null;
        switch (opcion){
            case 1:
                nuevoCliente=new ClienteParticulares();
                break;
            case 2:
                nuevoCliente=new ClienteEmpresas();
                break;
            default:
        }
        if (nuevoCliente==null)
            return;
        else if (nuevoCliente instanceof ClienteEmpresas) {
            crearCliente(nuevoCliente);
            gestion.nuevoCliente(nuevoCliente);
        }else if (nuevoCliente instanceof ClienteParticulares){
            crearCliente(nuevoCliente);
            System.out.println("Apellido:");
            ((ClienteParticulares) nuevoCliente).setApellido1(sc.next());
            gestion.nuevoCliente(nuevoCliente);
        }
    }

    private void crearCliente(Cliente nuevoCliente) {
        System.out.println("Introduce los datos requeridos.");
        System.out.println("-------------------------------");
        System.out.print("NIF:");
        nuevoCliente.setNIF(sc.next());

        System.out.print("E-mail:");
        nuevoCliente.setCorreo_e(sc.next());

        Direccion direccion = new Direccion();
        System.out.println("Introduce la direccion:");
        System.out.print("Provincia:");
        direccion.setProvincia(sc.next());

        System.out.print("Poblacion:");
        direccion.setPoblacion(sc.next());

        System.out.print("CodigoPostal:");
        direccion.setCP(sc.nextInt());
        nuevoCliente.setDireccion(direccion);

        System.out.print("Nombre:");
        nuevoCliente.setNombre(sc.next());
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
        return;
    }
}
