package baseDeDatos;

public class Direccion{
    private int CP;
    private String provincia;
    private String poblacion;

    public Direccion() {
        this.CP=0;
        this.poblacion=new String();
        this.provincia=new String();
    }

    public Direccion(int CP, String provincia, String poblacion){
        this.CP=CP;
        this.poblacion=poblacion;
        this.provincia=provincia;
    }
}