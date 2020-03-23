package gestion.excepciones;

public class ListaDeLlamadasVaciaException extends Exception {

    public ListaDeLlamadasVaciaException() {
        super("El cliente no ha realizado ninguna llamada");
    }
}
