package data.cliente.datos;

import java.io.Serializable;

public class Direccion implements Serializable {

    private int CP;
    private String provincia;
    private String poblacion;

    public Direccion(int CP, String provincia, String poblacion){
        this.CP = CP;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public int getCP() {
        return CP;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getPoblacion() {
        return poblacion;
    }
}