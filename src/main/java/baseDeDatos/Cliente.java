package baseDeDatos;

import java.time.LocalDate;

public abstract class Cliente {

    private String nombre;
    private String NIF;
    private String correo_e;
    private LocalDate fecha;
    private Tarifa tarifa;
    private Direccion direccion;

    Cliente(String nombre, String NIF, String correo_e, Direccion direccion){
        this.nombre=nombre;
        this.NIF=NIF;
        this.fecha=LocalDate.now();
        this.correo_e=correo_e;
        this.tarifa=new Tarifa();
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

    public void setTarifa(int eurosMinuto) {
        this.getTarifa().setEurosMinuto(eurosMinuto);
    }

    @Override
    public String toString() {
        return "baseDeDatos.Cliente:" + '\n' +
                "nombre='" + nombre + '\n' +
                "NIF='" + NIF + '\n' +
                "correo_e=" + correo_e + '\n' +
                "fecha=" + fecha + '\n' +
                "tarifa=" + tarifa + '\n' +
                "direccion=" + direccion
                ;
    }


}
