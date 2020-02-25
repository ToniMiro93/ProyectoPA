import java.time.LocalDate;

public class ClientesParticulares extends Clientes{
    private String apellido1;

    ClientesParticulares(String nombre, String NIF, String correo_e, LocalDate fecha, Tarifa tarifa, Direccion direccion, String apellido1) {
        super(nombre, NIF, correo_e, fecha, tarifa, direccion);
        this.apellido1=apellido1;
    }
}
