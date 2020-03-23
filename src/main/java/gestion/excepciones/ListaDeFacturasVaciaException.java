package gestion.excepciones;

public class ListaDeFacturasVaciaException extends Exception{

    public ListaDeFacturasVaciaException() {
        super("El cliente no se le han emitido facturas");
    }
}
