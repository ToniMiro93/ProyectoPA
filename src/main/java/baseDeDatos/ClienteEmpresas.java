package baseDeDatos;

import java.time.LocalDate;

public class ClienteEmpresas extends Cliente {
    ClienteEmpresas(String nombre, String NIF, String correo_e, LocalDate fecha, Tarifa tarifa, Direccion direccion) {
        super(nombre, NIF, correo_e, fecha, direccion);
    }
}
