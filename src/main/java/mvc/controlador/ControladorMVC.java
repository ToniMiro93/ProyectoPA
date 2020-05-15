package mvc.controlador;
import mvc.modelo.ActualizaModelo;
import mvc.modelo.Modelo;
import mvc.vista.*;


public class ControladorMVC implements Controlador{
    private InterrogaVista vista;
    private ActualizaModelo modelo;

    @Override
    public void crearCliente(String nombre,String apellidos,String nif, String email, String poblacion, String provincia, int cp){
        modelo.crearCliente(nombre,apellidos,nif,email,poblacion,provincia,cp);
    }

    @Override
    public void borrarCliente(String dni) {
        modelo.borrarCliente(dni);
    }

    @Override
    public void cambiarTarifa() {

    }

    @Override
    public void recuperarCliente() {

    }

    @Override
    public void listarClientes() {

    }

    @Override
    public void clientesEntreFechas() {

    }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

    public void setModelo(ActualizaModelo modelo) {
        this.modelo = modelo;
    }
}
