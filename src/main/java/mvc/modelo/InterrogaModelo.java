package mvc.modelo;

import data.cliente.Cliente;
import mvc.modelo.tablas.ModeloTablas;
import mvc.modelo.tablas.ModeloTablaClientes;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public interface InterrogaModelo {
    AbstractTableModel listarClientes();
    AbstractTableModel clientesEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
    AbstractTableModel recuperarCliente(String nif);
    AbstractTableModel mostrarLlamadas(String nif);
    AbstractTableModel llamadasEntreFechas(String nif, LocalDate fechaInicio, LocalDate fechaFin);
    AbstractTableModel recuperarFactura(int codigo);
    AbstractTableModel mostrarFacturas(String nif);
    AbstractTableModel facturasEntreFechas(String nif, LocalDate fechaInicio, LocalDate fechaFin);
}
