package baseDeDatos.clientes;

import baseDeDatos.Fecha;
import baseDeDatos.clientes.datos.Direccion;
import baseDeDatos.clientes.datos.Tarifa;
import baseDeDatos.llamadas.Llamada;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;

public abstract class Cliente implements Serializable, Fecha {

    private String nombre;
    private String NIF;
    private String correo_e;
    private LocalDate fecha;
    private Tarifa tarifa;
    private Direccion direccion;
    private HashSet<Llamada> llamadas;

    Cliente(String nombre, String NIF, String correo_e, Direccion direccion){
        this.nombre=nombre;
        this.NIF=NIF;
        this.fecha=LocalDate.now();
        this.correo_e=correo_e;
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
        return "baseDeDatos.clientes.Cliente:" + '\n' +
                "nombre='" + nombre + '\n' +
                "NIF='" + NIF + '\n' +
                "correo_e=" + correo_e + '\n' +
                "fecha=" + fecha + '\n' +
                "tarifa=" + tarifa + '\n' +
                "direccion=" + direccion
                ;
    }


}
