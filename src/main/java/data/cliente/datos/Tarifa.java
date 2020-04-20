package data.cliente.datos;

import data.llamada.Llamada;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {

    private int precio;

    public Tarifa(int precio) {
        this.precio=precio;
    }

    public int getPrecio() {
        return precio;
    }
    public int getPrecio(Llamada llamada){
        return precio;
    }
}
