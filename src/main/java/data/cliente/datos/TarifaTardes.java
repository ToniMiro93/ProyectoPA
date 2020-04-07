package data.cliente.datos;

import data.llamada.Llamada;

import java.time.LocalDate;
import java.time.LocalTime;

public class TarifaTardes extends Tarifa {
    Tarifa tarifa;

    public TarifaTardes(Tarifa tarifa){
        super(5);
        this.tarifa=tarifa;
    }
    public int getPrecio(Llamada llamada){
        int recubierta = tarifa.getPrecio();
        int precioTardes = super.getPrecio();
        if (recubierta>precioTardes) {
            if (llamada.getHora().compareTo(LocalTime.of(16, 00)) >= 0 && llamada.getHora().compareTo(LocalTime.of(20, 00)) <= 0) {
                return precioTardes;
            }
        }
        return recubierta;
    }
}
