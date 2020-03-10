import aplicacion.MenuPrincipal;

import java.io.*;

public class Menu {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MenuPrincipal programa;
        try {
            FileInputStream fis = new FileInputStream("database.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            programa = (MenuPrincipal) ois.readObject();
            ois.close();
        } catch (FileNotFoundException error){
          programa = new MenuPrincipal();
        }
        programa.start();

        FileOutputStream fos = new FileOutputStream("database.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(programa);
        oos.close();
    }
}
