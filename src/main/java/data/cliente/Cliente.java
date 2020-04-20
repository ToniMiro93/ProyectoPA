package data.cliente;

import data.Fecha;
import data.cliente.datos.Direccion;
import data.tarifas.Tarifa;
import data.tarifas.TarifaBasica;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Cliente implements Serializable, Fecha {

    String nombre;
    String NIF;
    String eMail;
    LocalDate fecha;
    Tarifa tarifa;
    Direccion direccion;

    Cliente(String nombre, String NIF, String eMail, Direccion direccion){
        this.nombre = nombre;
        this.NIF = NIF;
        this.fecha = LocalDate.now();
        this.eMail = eMail;
        this.tarifa = new TarifaBasica();
        this.direccion=direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        if(tarifa!=null)
            this.tarifa=tarifa;
    }

    @Override
    public String toString() {
        return "Cliente:" + '\n' +
                "\tnombre = " + nombre + '\n' +
                "\tNIF = " + NIF + '\n' +
                "\teMail = " + eMail + '\n' +
                "\tfecha = " + fecha + '\n' +
                "\ttarifa = " + tarifa + '\n' +
                "\tdireccion = " + direccion
                ;
    }

    @Override
    public LocalDate getFecha() {
        return fecha;
    }
}
