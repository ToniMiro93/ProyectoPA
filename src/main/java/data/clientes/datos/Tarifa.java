package data.clientes.datos;

import java.io.Serializable;

public class Tarifa implements Serializable {
    private int eurosMinuto=1;

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
