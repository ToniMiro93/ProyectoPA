package aplicacion;

import gestion.Gestion;

import java.io.Serializable;
import java.util.Scanner;

public interface Menu extends Serializable {

    public Scanner sc = new Scanner(System.in);

    public void start();

    public int getOpcion(int i);

    public void mostrarOpciones();
}
