package baseDeDatos.clientes.datos;

public class Tarifa {
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
