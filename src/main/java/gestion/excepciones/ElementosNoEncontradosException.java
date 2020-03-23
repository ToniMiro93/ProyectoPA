package gestion.excepciones;

public class ElementosNoEncontradosException extends Exception {

    public ElementosNoEncontradosException() {
        super("No se ha encontrado ningun elemento entre la fechas");
    }
}
