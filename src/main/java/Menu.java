import aplicacion.MenuPrincipal;

import java.io.*;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MenuPrincipal programa = cargarPrograma();
        programa.start();
        guardarPrograma(programa);
    }

    private static MenuPrincipal cargarPrograma() throws IOException, ClassNotFoundException{
        MenuPrincipal programa;
        System.out.print("Quieres cargar una base de datos anterior? s/n:");
        Scanner sc = new Scanner(System.in);
        String respuesta = sc.next();

        if ( respuesta.equals("s") ) {
            System.out.print("Indica el nombre de la base de datos (*.bin): ");
            respuesta = sc.next();
            try {
                FileInputStream fis = new FileInputStream(respuesta);
                ObjectInputStream ois = new ObjectInputStream(fis);
                programa = (MenuPrincipal) ois.readObject();
                ois.close();
            } catch (FileNotFoundException error) {
                programa = new MenuPrincipal();
            }
        }
        else {
            programa = new MenuPrincipal();
        }
        return programa;
    }
    private static void guardarPrograma(MenuPrincipal programa) throws IOException, ClassNotFoundException{
        Scanner sc = new Scanner(System.in);
        String respuesta;

        System.out.print("Quieres guardar la base de datos? s/n: ");
        respuesta = sc.next();
        if (respuesta.equals("s")) {
            System.out.print("Indica el nombre de la base de datos: ");
            respuesta = sc.next();
            FileOutputStream fos = new FileOutputStream(respuesta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(programa);
            oos.close();
        }
    }
}
