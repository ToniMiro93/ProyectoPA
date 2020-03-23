package data.cliente;

import data.Fecha;
import data.cliente.datos.Direccion;
import data.cliente.datos.Tarifa;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Cliente implements Serializable, Fecha {

    private String nombre;
    private String NIF;
    private String eMail;
    private LocalDate fecha;
    private Tarifa tarifa;
    private Direccion direccion;

    Cliente(String nombre, String NIF, String eMail, Direccion direccion){
        this.nombre = nombre;
        this.NIF = NIF;
        this.fecha = LocalDate.now();
        this.eMail = eMail;
        this.tarifa = new Tarifa(1);
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
        this.getTarifa().setEurosMinuto(tarifa.getEurosMinuto());
    }

    @Override
    public String toString() {
        return "Cliente:" + '\n' +
                mostrarNombre() +
//                "\tnombre = " + nombre + '\n' +
                "\tNIF = " + NIF + '\n' +
                "\teMail = " + eMail + '\n' +
                "\tfecha = " + fecha + '\n' +
                "\ttarifa = " + tarifa + '\n' +
                "\tdireccion = " + direccion
                ;
    }

    private String mostrarNombre(){
        return "\tnombre = " + nombre + '\n';
    }

    @Override
    public LocalDate getFecha() {
        return fecha;
    }
}
