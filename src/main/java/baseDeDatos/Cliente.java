package baseDeDatos;

import java.time.LocalDate;

public abstract class Cliente {

    private String nombre;
    private String NIF;
    private String correo_e;
    private LocalDate fecha;
    private Tarifa tarifa;
    private Direccion direccion;

    Cliente(String nombre, String NIF, String correo_e, LocalDate fecha, Direccion direccion){
        this.nombre=nombre;
        this.NIF=NIF;
        this.fecha=fecha;
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
