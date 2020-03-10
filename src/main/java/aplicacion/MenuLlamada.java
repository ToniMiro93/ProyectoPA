package aplicacion;

import data.llamadas.Llamada;
import gestion.Gestion;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuLlamada implements Menu{

    public transient Scanner sc;
    private Gestion gestion;

    public MenuLlamada(Gestion gestion) {
        this.gestion = gestion;
    }

    public void start(){
        sc=new Scanner(System.in);
        while (true) {
            mostrarOpciones();
            int opcion = getOpcion(4);
            switch (opcion) {
                case 1:
                    darAltaLlamada();
                    break;
                case 2:
                    listarLLamadas();
                    break;
                case 3:
                    llamadasEntreFechas();
                    break;
                case 4:
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
        System.out.println("3)Listar llamadas realizadas entre dos fechas");
        System.out.println("4)Salir del menu de llamadas");
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

    public void llamadasEntreFechas (){
        System.out.println("-----------------");
        System.out.println("Introduce NIF");
        String NIF=sc.next();
        System.out.println("Introduce fecha Inicial");
        System.out.println("Introduce el dia:");
        int dia=sc.nextInt();
        System.out.println("Introduce el mes");
        int mes=sc.nextInt();
        System.out.println("Introduce el año");
        int ano=sc.nextInt();
        LocalDate fechaInicial=LocalDate.of(ano,mes,dia);
        System.out.println("Introduce fecha fINAL");
        System.out.println("Introduce el dia:");
        dia=sc.nextInt();
        System.out.println("Introduce el mes");
        mes=sc.nextInt();
        System.out.println("Introduce el año");
        ano=sc.nextInt();
        LocalDate fechaFinal=LocalDate.of(ano,mes,dia);
        gestion.getDatosEntreFechas(gestion.listarLlamadas(gestion.recuperarCliente(NIF)),fechaInicial,fechaFinal);
    }
}
