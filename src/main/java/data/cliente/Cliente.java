package data.cliente;

import data.Fecha;
import data.cliente.datos.Direccion;
import data.cliente.datos.Tarifa;
import data.llamada.Llamada;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;

public abstract class Cliente implements Serializable, Fecha {

    private String nombre;
    private String NIF;
    private String correoElectronico;
    private LocalDate fecha;
    private Tarifa tarifa;
    private Direccion direccion;
    private HashSet<Llamada> llamadas;

    Cliente(String nombre, String NIF, String correo_e, Direccion direccion){
        this.nombre=nombre;
        this.NIF=NIF;
        this.fecha=LocalDate.now();
        this.correoElectronico =correo_e;
        this.tarifa=new Tarifa(1);
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

    public HashSet<Llamada> getLlamadas() {
        return llamadas;
    }

    public void setTarifa(Tarifa tarifa) {
        this.getTarifa().setEurosMinuto(tarifa.getEurosMinuto());
    }

    @Override
    public String toString() {
        return "Cliente:" + '\n' +
//                "\t" + metodo privado + '\n' +
                "\tnombre='" + nombre + '\n' +
                "\tNIF='" + NIF + '\n' +
                "\tcorreoElectronico=" + correoElectronico + '\n' +
                "\tfecha=" + fecha + '\n' +
                "\ttarifa=" + tarifa + '\n' +
                "\tdireccion=" + direccion
                ;
    }

//    private String mostrarNombe(Cliente){
//        if ()
//    }

    @Override
    public LocalDate getFecha() {
        return fecha;
    }
}
