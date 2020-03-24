package gestion.excepciones;

public class ClienteNotFoundException extends Exception{

    public ClienteNotFoundException(){
        super("Cliente no encontrado");
    }
}
