package Principal;

import gestion.Gestion;
import mvc.controlador.ControladorMVC;
import mvc.modelo.Modelo;
import mvc.vista.*;

import java.io.*;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*MenuPrincipal programa = cargarPrograma();
        programa.start();
        guardarPrograma(programa);*/
        ControladorMVC controlador = new ControladorMVC();
        VentanaInicial vista = new VentanaInicial();
        Modelo modelo = new Modelo();
        modelo.setVista(vista);
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        vista.creaGUI();

    }

    private static Gestion cargarPrograma() throws IOException, ClassNotFoundException{
        Gestion gestion;
        System.out.print("Quieres cargar una base de datos anterior? s/n:");
        Scanner sc = new Scanner(System.in);
        String respuesta = sc.next();

        if ( respuesta.equals("s") ) {
            System.out.print("Indica el nombre de la base de datos (*.bin): ");
            respuesta = sc.next();
            try {
                FileInputStream fis = new FileInputStream(respuesta);
                ObjectInputStream ois = new ObjectInputStream(fis);
                gestion = (Gestion) ois.readObject();
                ois.close();
            } catch (FileNotFoundException error) {
                gestion = new Gestion();
            }
        }
        else {
            gestion = new Gestion();
        }
        return gestion;
    }
    private static void guardarPrograma(Gestion gestion) throws IOException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        String respuesta;

        System.out.print("Quieres guardar la base de datos? s/n: ");
        respuesta = sc.next();
        if (respuesta.equals("s")) {
            System.out.print("Indica el nombre de la base de datos: ");
            respuesta = sc.next();
            FileOutputStream fos = new FileOutputStream(respuesta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gestion);
            oos.close();
        }
    }
}
