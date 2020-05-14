package data.tarifas;

import data.llamada.Llamada;

import java.time.DayOfWeek;

public class TarifaDomingo extends TarifaEspecial{


    public TarifaDomingo(Tarifa tarifa){
        super(0,tarifa);
    }

    public int getPrecio(Llamada llamada){
        if (DayOfWeek.SUNDAY == llamada.getFecha().getDayOfWeek())
            return super.getPrecio();
        else
            return tarifa.getPrecio(llamada);
    }
}
