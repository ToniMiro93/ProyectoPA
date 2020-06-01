package mvc.modelo;

import data.cliente.Cliente;
import mvc.modelo.tablas.ModeloTablas;
import mvc.modelo.tablas.ModeloTablaClientes;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public interface InterrogaModelo {

    //Todos las funciones que Vista llama en modelo devuelven un modelo que utilizaran cada una
    //de las tablas de Vista.
    //Cada funcion devolverá uno de los 3 modelos que hay (para Clientes, Facturas y Llamadas)
    AbstractTableModel listarClientes();
    AbstractTableModel clientesEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
    AbstractTableModel recuperarCliente(String nif);
    AbstractTableModel mostrarLlamadas(String nif);
    AbstractTableModel llamadasEntreFechas(String nif, LocalDate fechaInicio, LocalDate fechaFin);
    AbstractTableModel recuperarFactura(int codigo);
    AbstractTableModel mostrarFacturas(String nif);
    AbstractTableModel facturasEntreFechas(String nif, LocalDate fechaInicio, LocalDate fechaFin);
}
