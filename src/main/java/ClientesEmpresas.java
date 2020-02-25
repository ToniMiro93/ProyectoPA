import java.time.LocalDate;

public class ClientesEmpresas extends Clientes {
    ClientesEmpresas(String nombre, String NIF, String correo_e, LocalDate fecha, Tarifa tarifa, Direccion direccion) {
        super(nombre, NIF, correo_e, fecha, tarifa, direccion);
    }
}
