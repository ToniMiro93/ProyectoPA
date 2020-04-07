package data.cliente.datos;

import data.llamada.Llamada;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TarifaDomingo extends Tarifa{

    Tarifa tarifa;

    public TarifaDomingo(Tarifa tarifa){

        super(0);
        this.tarifa = tarifa;
    }
    public int getPrecio(Llamada llamada){
        if (DayOfWeek.SUNDAY==llamada.getFecha().getDayOfWeek())
            return super.getPrecio();
        else
            return tarifa.getPrecio(llamada);
}
}
