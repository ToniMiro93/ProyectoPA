package data.tarifas;

import data.llamada.Llamada;

import java.time.LocalTime;

public class TarifaTardes extends TarifaEspecial {

    public TarifaTardes(Tarifa tarifa){
        super(5,tarifa);
    }

    public int getPrecio(Llamada llamada){
        int recubierta = tarifa.getPrecio(llamada);
        int precioTardes = super.getPrecio();
        if (recubierta>precioTardes) {
            if (llamada.getHora().compareTo(LocalTime.of(16, 00)) >= 0 && llamada.getHora().compareTo(LocalTime.of(20, 00)) <= 0) {
                return precioTardes;
            }
        }
        return recubierta;
    }
}
