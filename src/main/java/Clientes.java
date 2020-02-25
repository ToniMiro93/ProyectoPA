import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

public class Clientes {

    private String nombre;
    private String NIF;
    private String correo_e;
    private LocalDate fecha;
    private Tarifa tarifa;
    private Direccion direccion;
    private

    Clientes(String nombre, String NIF, String correo_e, LocalDate fecha, Tarifa tarifa, Direccion direccion){
        this.nombre=nombre;
        this.NIF=NIF;
        this.fecha=fecha;
        this.correo_e=correo_e;
        this.tarifa=tarifa;
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

}
