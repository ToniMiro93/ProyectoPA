package aplicacion;

import data.cliente.ClienteEmpresa;
import data.cliente.datos.Direccion;
import gestion.Gestion;
import gestion.excepciones.ListaDeFacturasVaciaException;
import gestion.excepciones.ListaDeLlamadasVaciaException;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuFacturas implements Menu{

    public transient Scanner sc;
    private Gestion gestion;

    public MenuFacturas(Gestion gestion) {
        this.gestion = gestion;
    }

    public void start(){
        sc=new Scanner(System.in);
        while (true) {
            mostrarOpciones();
            int opcion = getOpcion(5);
            switch (opcion) {
                case 1:
                    emitirFactura();
                    break;
                case 2:
                    recuperarFacturaByCodigo();
                    break;
                case 3:
                    listarFacturasNIF();
                    break;
                case 4:
                    facturasEntreFechas();
                    break;
                case 5:
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
        System.out.println("Menú de gestion de facturas de telefonia v1.0");
        System.out.println("----------------------------------------------");
        System.out.println("1)Emitir factura.");
        System.out.println("2)Recuperar datos de una factura.");
        System.out.println("3)Recuperar todas las factuas");
        System.out.println("4)Listar facturas emitidas entre dos fechas");
        System.out.println("5)Salir del menu de facturas");
    }

    private void emitirFactura() {
        System.out.println("-----------------");
        System.out.println("1)Emitir factura de un cliente a partir de su NIF");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion = getOpcion(2);
        switch (opcion) {
            case 1:
                System.out.print("Introduce el NIF:");
                String NIF = sc.next();
                System.out.print("Introduce fecha de inicio:");
                System.out.print("Dia:");
                int dia=sc.nextInt();
                System.out.print("Mes:");
                int mes=sc.nextInt();
                System.out.print("Año:");
                int ano=sc.nextInt();
                LocalDate fechaInicio = LocalDate.of(ano,mes,dia);

                System.out.print("Introduce fecha fin:");
                System.out.print("Dia:");
                dia=sc.nextInt();
                System.out.print("Mes:");
                mes=sc.nextInt();
                System.out.print("Año:");
                ano=sc.nextInt();
                LocalDate fechaFin=LocalDate.of(ano,mes,dia);
                gestion.emitirFactura(new ClienteEmpresa("Pepe",
                        "11111111T", "pepe@email.es", new Direccion(1200,"castellon",
                        "castellon")),fechaInicio,fechaFin);
                break;
            case 2:
                return;
        }
    }

    private void recuperarFacturaByCodigo() {
        System.out.println("-----------------");
        System.out.println("1)Recuperar factura a partir de su codigo");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion = getOpcion(2);
        switch (opcion) {
            case 1:
                System.out.print("Introduce codigo");
                int cod = sc.nextInt();
                gestion.recuperarFactura(cod);
            case 2:
                return;
        }
    }

    private void listarFacturasNIF() {
        System.out.println("-----------------");
        System.out.println("1)Mostrar facturas de un cliente");
        System.out.println("2)(atras)");
        System.out.println("Escoge una opcion:");
        int opcion = getOpcion(2);
        switch (opcion) {
            case 1:System.out.print("Introduce el NIF:");
                String NIF = sc.next();
                gestion.listarFacturas(gestion.recuperarCliente(NIF));
                break;
            case 2:
                return;
        }
    }

    public void facturasEntreFechas (){
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
        gestion.getDatosEntreFechas(gestion.listarFacturas(gestion.recuperarCliente(NIF)),fechaInicial,fechaFinal);
    }
}
