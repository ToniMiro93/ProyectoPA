package mvc.modelo;

import java.time.LocalDate;

public interface ActualizaModelo {
    void crearCliente(String nombre,String apellidos,String nif, String email, String poblacion, String provincia, int cp);
    void borrarCliente(String dni);
    void cambiarTarifa(String nif, String tarifa);
    void anadirLLamada(String nif, long num, int dur);
    void emitirfactura(String nif, LocalDate fechaInicial, LocalDate fechaFin);
}
