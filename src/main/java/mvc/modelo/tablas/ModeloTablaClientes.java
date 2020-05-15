package mvc.modelo.tablas;

import data.cliente.Cliente;
import data.cliente.ClienteParticular;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class ModeloTablaClientes extends AbstractTableModel implements InterrogaTablas{
    final List<String> cabecera = Arrays.asList("Nombre", "Apellidos", "NIF", "Correo", "Fecha",
            "Codigo Postal", "Provincia", "Poblacion");
    List<Cliente> datos;


    public ModeloTablaClientes(List<Cliente> datos) {
        this.datos = datos;
    }

    public void setDatos(List<Cliente> datos) {
        this.datos = datos;
    }

    public int getRowCount(){
        return datos.size();
    }

    public int getColumnCount(){
        return cabecera.size();
    }

    public Object getValueAt(int fila, int columna){
        if (columna == 0) return datos.get(fila).getNombre();
        if (columna == 1) {
            if (datos.get(fila).getClass().equals(ClienteParticular.class)){
                ClienteParticular cliente = (ClienteParticular) datos.get(fila);
                return cliente.getApellidos();
            }
            else return "-es empresa-";
        }
        if (columna == 2) return datos.get(fila).getNIF();
        if (columna == 3) return datos.get(fila).geteMail();
        if (columna == 4) return datos.get(fila).getFecha().toString();
        if (columna == 5) return datos.get(fila).getDireccion().getCP();
        if (columna == 6) return datos.get(fila).getDireccion().getProvincia();
        if (columna == 7) return datos.get(fila).getDireccion().getPoblacion();
        else return "";
    }


    public String getColumnName(int columna){
        return cabecera.get(columna);
    }
}