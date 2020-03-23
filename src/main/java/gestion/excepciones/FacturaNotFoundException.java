package gestion.excepciones;

public class FacturaNotFoundException extends Exception {

    public FacturaNotFoundException() {
        super("No existe la factura");
    }
}
