package aplicacion;

import gestion.Gestion;

import java.io.Serializable;
import java.util.Scanner;

public class MenuPrincipal implements Menu{
    protected transient Scanner sc;
    public Gestion gestion;
    private MenuClientes menuClientes;
    private MenuLlamada menuLlamada;
    private MenuFacturas menuFacturas;

    public MenuPrincipal(){
        gestion=new Gestion();
        menuClientes = new MenuClientes(gestion);
        menuLlamada = new MenuLlamada(gestion);
        menuFacturas = new MenuFacturas(gestion);
    }


    public void start(){
        sc=new Scanner(System.in);
        while (true) {
            mostrarOpciones();
            int opcion = getOpcion(4);
            switch (opcion) {
                case 1:
                    menuClientes.start();
                    break;
                case 2:
                    menuLlamada.start();
                    break;
                case 3:
                    menuFacturas.start();
                    break;
                case 4:
                    return;
                default:
            }

        }
    }

    public void mostrarOpciones(){
        System.out.println("Menu de gestion de cliente de telefonia v1.0");
        System.out.println("----------------------------------------------");
        System.out.println("1)Gestionar cliente.");
        System.out.println("2)Gestionar llamada de un cliente.");
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
