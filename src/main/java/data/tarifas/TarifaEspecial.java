package data.tarifas;

public abstract class TarifaEspecial extends Tarifa {
    Tarifa tarifa;

    public TarifaEspecial(int precio, Tarifa tarifa) {
        super(precio);
        this.tarifa = tarifa;
    }
}
