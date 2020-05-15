package mvc.modelo.tablas;

import data.cliente.Cliente;
import data.cliente.ClienteParticular;
import data.tarifas.Tarifa;
import data.tarifas.TarifaBasica;
import data.tarifas.TarifaDomingo;
import data.tarifas.TarifaTardes;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class ModeloTablaClientes extends AbstractTableModel implements ModeloTablas {
    final List<String> cabecera = Arrays.asList("Nombre", "Apellidos", "NIF", "Correo", "Fecha",
            "Codigo Postal", "Provincia", "Poblacion", "Tarifa mas recien");
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
        if (columna == 8) {
            Tarifa tarifa = datos.get(fila).getTarifa();
            if (tarifa.getClass().equals(TarifaBasica.class))
                return "Tarifa basica";
            else if (tarifa.getClass().equals(TarifaTardes.class))
                return "Tarifa tardes";
            else if (tarifa.getClass().equals(TarifaDomingo.class))
                return "Tarifa domingos";
        }
        return "";
    }


    public String getColumnName(int columna){
        return cabecera.get(columna);
    }
}