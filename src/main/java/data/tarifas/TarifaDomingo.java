package data.tarifas;

import data.llamada.Llamada;

import java.time.DayOfWeek;

public class TarifaDomingo extends Tarifa{

    Tarifa tarifa;

    public TarifaDomingo(Tarifa tarifa){
        super(0);
        this.tarifa = tarifa;
    }

    public int getPrecio(Llamada llamada){
        if (DayOfWeek.SUNDAY == llamada.getFecha().getDayOfWeek())
            return super.getPrecio();
        else
            return tarifa.getPrecio(llamada);
    }
}
