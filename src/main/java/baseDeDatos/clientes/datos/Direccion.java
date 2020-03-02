package baseDeDatos.clientes.datos;

public class Direccion{
    private int CP;
    private String provincia;
    private String poblacion;

    public Direccion(int CP, String provincia, String poblacion){
        this.CP=CP;
        this.poblacion=poblacion;
        this.provincia=provincia;
    }

}