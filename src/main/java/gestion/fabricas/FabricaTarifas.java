package gestion.fabricas;

import data.tarifas.Tarifa;
import data.tarifas.TarifaBasica;
import data.tarifas.TarifaDomingo;
import data.tarifas.TarifaTardes;

public class FabricaTarifas {

    /*
    No la utilizamos pero la guardamos en caso de
    que no funcione la fabrica parametrizada
     */


    public Tarifa getTarifaBase(){
        return new TarifaBasica();
    }

    public Tarifa getTarifaTardes(Tarifa tarifaRecubierta){
        return new TarifaTardes(tarifaRecubierta);
    }

    public Tarifa getTarifaDomingos(Tarifa tarifaRecubierta){
        return new TarifaDomingo(tarifaRecubierta);
    }
}
