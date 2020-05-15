package mvc.modelo;

import data.cliente.Cliente;
import mvc.modelo.tablas.ModeloTablas;
import mvc.modelo.tablas.ModeloTablaClientes;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public interface InterrogaModelo {
    AbstractTableModel listarClientes();
    ArrayList<Cliente> clientesEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
    AbstractTableModel recuperarCliente(String nif);
}
