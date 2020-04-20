package gestion.fabricas;

import data.tarifas.Tarifa;
import data.tarifas.TarifaDomingo;
import data.tarifas.TarifaTardes;

public class FabricaTarifasParametrizada {

    public Tarifa getTarifa(TipoTarifa tipo, Tarifa tarifaRecubrir){
        Tarifa tarifa = new TarifaTardes(tarifaRecubrir);
        switch (tipo) {
            case DOMINGOS:
                tarifa = new TarifaDomingo(tarifaRecubrir);
                break;
        }
        return tarifa;
    }
}
