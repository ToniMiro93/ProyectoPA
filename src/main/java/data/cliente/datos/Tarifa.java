package data.cliente.datos;

import java.io.Serializable;

public class Tarifa implements Serializable {

    private int eurosMinuto;

    public Tarifa(int eurosMinuto) {
        this.eurosMinuto = eurosMinuto;
    }

    public int getEurosMinuto() {
        return eurosMinuto;
    }

    public void setEurosMinuto(int eurosMinuto) {
        this.eurosMinuto = eurosMinuto;
    }
}
