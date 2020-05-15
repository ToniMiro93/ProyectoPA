package mvc.controlador;
import mvc.modelo.ActualizaModelo;
import mvc.modelo.Modelo;
import mvc.vista.*;

import java.time.LocalDate;


public class ControladorMVC implements Controlador{
    private InterrogaVista vista;
    private ActualizaModelo modelo;

    @Override
    public void crearCliente(String nombre,String apellidos,String nif, String email, String poblacion, String provincia, int cp){
        modelo.crearCliente(nombre,apellidos,nif,email,poblacion,provincia,cp);
    }

    @Override
    public void borrarCliente(String nif) {
        modelo.borrarCliente(nif);
    }

    @Override
    public void cambiarTarifa(String nif, String tarifa) {
        modelo.cambiarTarifa(nif, tarifa);
    }

    public void anadirLlamada(String nif, long num, int dur){
        modelo.anadirLLamada(nif, num, dur);
    }

    @Override
    public void emitirFactura(String nif, LocalDate fechaInicial, LocalDate fechaFin) {
        modelo.emitirfactura(nif, fechaInicial, fechaFin);
    }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

    public void setModelo(ActualizaModelo modelo) {
        this.modelo = modelo;
    }
}
