package mvc.vista.tablas.tablaLlamadas;

import data.llamada.Llamada;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class ModeloTablaLlamadas extends AbstractTableModel {
    final List<String> cabecera = Arrays.asList("Numero de destino", "Fecha de llamada",
            "Hora de la llamada", "duracion");
    List<Llamada> datos;

    public ModeloTablaLlamadas(final List<Llamada> datos){
        this.datos = datos;
    }

    public int getRowCount(){
        return datos.size();
    }

    public int getColumnCount(){
        return cabecera.size();
    }

    public Object getValueAt(int fila, int columna){
        if (columna == 0) return datos.get(fila).getNumDest();
        if (columna == 1) return datos.get(fila).getFecha();
        if (columna == 2) return datos.get(fila).getHora();
        if (columna == 3) return datos.get(fila).getDuracion();
        else return "";
    }

    public String getColumnName(int columna){
        return cabecera.get(columna);
    }
}
