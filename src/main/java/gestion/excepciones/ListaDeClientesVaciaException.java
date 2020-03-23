package gestion.excepciones;

public class ListaDeClientesVaciaException extends Exception {

    public ListaDeClientesVaciaException() {
        super("No hay ningun cliente");
    }
}
