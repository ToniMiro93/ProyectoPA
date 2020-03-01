package baseDeDatos;

import java.time.LocalDate;

public class ClienteParticulares extends Cliente {
    private String apellido1;

    public ClienteParticulares(){
        apellido1= new String();
    }

    public ClienteParticulares(String nombre, String NIF, String correo_e, Direccion direccion, String apellido1) {
        super(nombre, NIF, correo_e, direccion);
        this.apellido1=apellido1;
    }

    public ClienteParticulares(ClienteParticulares cliente){
        super(cliente.getNombre(),cliente.getNIF(),cliente.getCorreo_e(),cliente.getDireccion());
        apellido1=cliente.apellido1;
    }

    @Override
    public String toString() {
        return super.toString() +
                "apellido1='" + apellido1;
    }
}
