package mvc.modelo.tablas;

import data.facturas.Factura;
import data.tarifas.Tarifa;
import data.tarifas.TarifaBasica;
import data.tarifas.TarifaDomingo;
import data.tarifas.TarifaTardes;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;

public class ModeloTablaFacturas extends AbstractTableModel implements ModeloTablas {
    final List<String> cabecera = Arrays.asList("Código", "Fecha de emisión", "Inicio del periodo",
            "Final del periodo", "Tarifa aplicada", "Importe");
    List<Factura> datos;

    public ModeloTablaFacturas(final List<Factura> datos){
        this.datos = datos;
    }

    public int getRowCount(){
        return datos.size();
    }

    public int getColumnCount(){
        return cabecera.size();
    }

    public Object getValueAt(int fila, int columna){
        if (columna == 0) return datos.get(fila).getCodigo();
        if (columna == 1) return datos.get(fila).getFecha();
        if (columna == 2) return datos.get(fila).getInicioPeriodo();
        if (columna == 3) return datos.get(fila).getFinalPeriodo();
        if (columna == 4) {
            Tarifa tarifa = datos.get(fila).getTarifaAplicada();
            if (tarifa.getClass().equals(TarifaBasica.class))
                return "Tarifa basica";
            else if (tarifa.getClass().equals(TarifaTardes.class))
                return "Tarifa de Tardes";
            else if (tarifa.getClass().equals(TarifaDomingo.class))
                return "Tarifa de Domingos";
        }
        if (columna == 5) return datos.get(fila).getImporte();
        else return "";
    }

    public String getColumnName(int columna){
        return cabecera.get(columna);
    }
}
