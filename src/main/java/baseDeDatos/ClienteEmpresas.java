package baseDeDatos;

import java.time.LocalDate;

public class ClienteEmpresas extends Cliente {
    ClienteEmpresas(){
      super();
    }
    ClienteEmpresas(String nombre, String NIF, String correo_e, Direccion direccion) {
        super(nombre, NIF, correo_e, direccion);
    }
}
