package aplicacion;

import baseDeDatos.llamadas.Llamada;
import gestion.Gestion;

import java.util.Scanner;

public class MenuLlamada implements Menu{

    public Scanner sc = new Scanner(System.in);
    private Gestion gestion;

    public MenuLlamada(Gestion gestion) {
        this.gestion = gestion;
    }

    public void start(){
        while (true) {
            mostrarOpciones();
            int opcion = getOpcion(3);
            switch (opcion) {
                case 1:
                    darAltaLlamada();
                    break;
                case 2:
                    listarLLamadas();
                    break;
                case 3:
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
        System.out.println("Menú de gestion de llamadas de telefonia v1.0");
        System.out.println("----------------------------------------------");
        System.out.println("1)Añadir llamada.");
        System.out.println("2)Listar llamadas.");
        System.out.println("3)Salir del menu de llamadas");
    }

    private void darAltaLlamada(){
        System.out.println("-----------------");
        System.out.println("1)Dar de alta llamada a partir de su NIF.");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion = getOpcion(2);
        switch (opcion){
            case 1:
                System.out.print("Introduce el NIF:");
                String NIF=sc.next();
                System.out.print("Introduce el numero de destino:");
                long numDest=sc.nextLong();
                System.out.print("Introduce la duracion de la llamada(min):");
                int duracion=sc.nextInt();
                Llamada llamada = new Llamada(numDest, duracion);
                gestion.anadirLlamada(gestion.recuperarCliente(NIF), llamada);
                break;
            case 2:
                return;
        }
    }

    private void listarLLamadas() {
        System.out.println("-----------------");
        System.out.println("1)Mostrar Listado de llamadas de un cliente");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion = getOpcion(2);
        switch (opcion) {
            case 1:
                System.out.print("Introduce el NIF:");
                String NIF = sc.next();
                gestion.listarLlamadas(gestion.recuperarCliente(NIF));
            case 2:
                return;
        }
    }
}
