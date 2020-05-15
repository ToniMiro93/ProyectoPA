package mvc.controlador;

public interface Controlador {
    void borrarCliente(String nif);
    void cambiarTarifa();
    void clientesEntreFechas();
    void crearCliente(String nombre,String apellidos,String nif, String email, String poblacion, String provincia, int cp);
}
