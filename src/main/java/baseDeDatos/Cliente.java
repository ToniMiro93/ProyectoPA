package baseDeDatos;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Cliente {

    private String nombre;
    private String NIF;
    private String correo_e;
    private LocalDate fecha;
    private Tarifa tarifa;
    private Direccion direccion;

    Cliente (){
        this.nombre=new String();
        this.NIF=new String();
        this.fecha=LocalDate.now();
        this.correo_e=new String();
        this.tarifa=new Tarifa();
        this.direccion=new Direccion();
    }
    Cliente(String nombre, String NIF, String correo_e, Direccion direccion){
        this.nombre=nombre;
        this.NIF=NIF;
        this.fecha=LocalDate.now();
        this.correo_e=correo_e;
        this.tarifa=new Tarifa();
        this.direccion=direccion;
    }

    Cliente(Cliente cliente){
        this.nombre=cliente.nombre;
        this.NIF=cliente.NIF;
        this.fecha=cliente.fecha;
        this.correo_e=cliente.correo_e;
        this.tarifa=cliente.tarifa;
        this.direccion=cliente.direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public String getCorreo_e() {
        return correo_e;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setTarifa(int eurosMinuto) {
        this.getTarifa().setEurosMinuto(eurosMinuto);
    }

    @Override
    public String toString() {
        return "baseDeDatos.Cliente:" +
                "nombre='" + nombre + '\'' +
                ", NIF='" + NIF + '\'' +
                ", correo_e='" + correo_e + '\'' +
                ", fecha=" + fecha +
                ", tarifa=" + tarifa +
                ", direccion=" + direccion
                ;
    }


}
