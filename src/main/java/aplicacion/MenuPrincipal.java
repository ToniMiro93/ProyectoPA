package aplicacion;

import gestion.Gestion;

import java.util.Scanner;

public class MenuPrincipal implements Menu{
    protected Scanner sc;
    public Gestion gestion;

    public MenuPrincipal(){
        sc=new Scanner(System.in);
        gestion=new Gestion();
    }

    public void start(){
        while (true) {
            mostrarOpciones();
            int opcion = getOpcion(4);
            switch (opcion) {
                case 1:
                    MenuClientes menuClientes = new MenuClientes(gestion);
                    menuClientes.start();
                    break;
                case 2:
                    MenuLlamada menuLlamada = new MenuLlamada(gestion);
                    menuLlamada.start();
                    break;
                case 3:
                    MenuFacturas menuFacturas = new MenuFacturas(gestion);
                    menuFacturas.start();
                    break;
                case 4:
                    return;
                default:
            }

        }
    }

    public void mostrarOpciones(){
        System.out.println("Menu de gestion de clientes de telefonia v1.0");
        System.out.println("----------------------------------------------");
        System.out.println("1)Gestionar clientes.");
        System.out.println("2)Gestionar llamadas de un cliente.");
        System.out.println("3)Gestionar facturación de un cliente.");
        System.out.println("4)Salir.");
        System.out.print("Elige la opcion que desee realizar:");
    }


    public int getOpcion(int i) {
        int opcion;
        opcion=sc.nextInt();
        while (opcion<1 || opcion>i) {
            System.out.println("Escoge una opcion correcta!");
            opcion=getOpcion(i);
        }
        return opcion;
    }

}
