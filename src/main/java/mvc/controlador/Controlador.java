package mvc.controlador;

import java.time.LocalDate;

public interface Controlador {
    void borrarCliente(String nif);
    void cambiarTarifa(String nif, String tarifa);
    void crearCliente(String nombre,String apellidos,String nif, String email, String poblacion, String provincia, int cp);
    void anadirLlamada(String nif, long num, int dur);
    void emitirFactura(String nif, LocalDate fechaInicial, LocalDate fechaFin);
}
