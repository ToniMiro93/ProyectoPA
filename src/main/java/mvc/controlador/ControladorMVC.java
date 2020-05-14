package mvc.controlador;
import mvc.vista.*;


public class ControladorMVC implements Controlador{
    private InterrogaVista vista;

    @Override
    public void anyadirCliente() {
        crearCliente();
    }

    private void crearCliente(){
        VentanaClienteNuevo ventana=new VentanaClienteNuevo();
        ventana.creaGUI();

    }

    @Override
    public void borrarCliente() {

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

}
