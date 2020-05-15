package mvc.controlador;

public interface Controlador {
    void borrarCliente(String dni);
    void cambiarTarifa();
    void recuperarCliente();
    void listarClientes();
    void clientesEntreFechas();
    void crearCliente(String nombre,String apellidos,String nif, String email, String poblacion, String provincia, int cp);
}
