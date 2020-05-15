package mvc.modelo;

public interface ActualizaModelo {
    void crearCliente(String nombre,String apellidos,String nif, String email, String poblacion, String provincia, int cp);
    void borrarCliente(String dni);
}
