import java.time.LocalDate;

public class ClienteParticulares extends Cliente {
    private String apellido1;

    ClienteParticulares(String nombre, String NIF, String correo_e, LocalDate fecha, Tarifa tarifa, Direccion direccion, String apellido1) {
        super(nombre, NIF, correo_e, fecha, tarifa, direccion);
        this.apellido1=apellido1;
    }

    @Override
    public String toString() {
        return super.toString() +
                "apellido1='" + apellido1;
    }
}
